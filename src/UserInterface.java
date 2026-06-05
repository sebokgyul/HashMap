import java.util.Scanner;

public class UserInterface {
  private HashMap map;
  private Scanner scanner;

  public UserInterface(Scanner scanner, HashMap map) {
    this.map = map;
    this.scanner = scanner;
  }

  public void start() {
    while(true) {
      System.out.println();
      System.out.println("Enter a command");
      System.out.println();
      System.out.println("1. put");
      System.out.println("2. get");
      System.out.println("3. list");
      System.out.println("4. quit");
      System.out.println();
      String command = scanner.nextLine();

      if(command.equals("quit") || command.equals("4")) {
        break;
      } else if(command.equals("put") || command.equals("1")) {
        System.out.println();
        System.out.print("Enter a String to put: ");
        String value = scanner.nextLine();
        System.out.print("Enter a key for the String: ");
        String key = scanner.nextLine();
        map.put(key, value);
      } else if(command.equals("get") || command.equals("2")) {
        System.out.println();
        System.out.print("Enter the key: ");
        String key = scanner.nextLine();
        System.out.println(map.get(key));
        System.out.println();
      } else if(command.equals("list") || command.equals("3")) {
        map.printMap();
      }
    }
  }
}
