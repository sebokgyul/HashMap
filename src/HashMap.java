public class HashMap {

  private Node[] table;
  private int mapSize;
  private static final double LOAD_FACTOR = 0.75;

  public HashMap() {
    this.table = new Node[8];
    this.mapSize = 0;
  }

  private static class Node {
    String key;
    String value;
    Node next;

    private Node(String key, String value) {
      this.key = key;
      this.value = value;
    }

    public String toString() {
      return this.key + " --> " + this.value;
    }
  }

  public void put(String key, String value) {
    int index = (key.hashCode() & 0x7fffffff) % this.table.length;
    Node current = table[index];

    while(current != null) {
      if(current.key.equals(key)) {
        current.value = value;
        return;
      }
      current = current.next;
    }
    if((double) this.mapSize / this.table.length > LOAD_FACTOR) {
      resize();
    }

    Node newNode = new Node(key, value);
    newNode.next = table[index];
    table[index] = newNode;
    this.mapSize++;
  }

  public String get(String key) {
    int index = (key.hashCode() & 0x7fffffff) % this.table.length;
    Node current = table[index];

    while(current != null) {
      if(current.key.equals(key)) {
        return current.value;
      }
      current = current.next;
    }
    return "----No such key----";
  }

  public void remove(String key) {
    int index = (key.hashCode() & 0x7fffffff) % this.table.length;
    Node current = table[index];
    Node prev = null;

    while(current != null) {
      if (current.key.equals(key)) {
        if (prev == null) {
          table[index] = current.next;
        } else {
          prev.next = current.next;
        }
        this.mapSize--;
        return;
      }
      prev = current;
      current = current.next;
    }
  }

  public void resize() {
    Node[] oldTable = this.table;
    this.table = new Node[oldTable.length * 2];
    this.mapSize = 0;

    for(Node head : oldTable) {
      Node current = head;
      while(current != null) {
        put(current.key, current.value);
        current = current.next;
      }
    }
  }

  public void printMap() {
    int numOfValues = 0;
    for(int i = 0; i < this.table.length; i++) {
      Node current = table[i];

      while(current != null) {
        System.out.println(current);
        current = current.next;
        numOfValues++;
      }
    }
    if(numOfValues == 0) {
      System.out.println("----The HashMap is empty!----");
    }
  }

  public int getSize() {
    return this.mapSize;
  }
}
