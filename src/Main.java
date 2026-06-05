import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    HashMap map = new HashMap();
    Scanner scanner = new Scanner(System.in);
    UserInterface ui = new UserInterface(scanner, map);

    ui.start();
  }
}
