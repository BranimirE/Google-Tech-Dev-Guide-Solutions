import java.util.*;

public class Main {
  public String stringSplosion(String str) {
    int n = str.length(), idx = 0;
    char response[] = new char[n * (n + 1) / 2];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        response[idx++] = str.charAt(j);
      }
    }
    System.out.println("asdf");
    return new String(response);
  }

  public static void main(String args[]) {
    Main main = new Main();
    System.out.println(main.stringSplosion("Cabc"));
  }
}
