import java.util.*;

public class Main {
  public int sumNumbers(String str) {
    int answer = 0;
    int cur = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (Character.isDigit(c)) {
        cur = cur * 10 + (c - '0');
      } else {
        answer = answer + cur;
        cur = 0;
      }
    }
    answer = answer + cur;
    return answer;
  }

  public static void main(String args[]) {
    Main main = new Main();
    System.out.println(main.sumNumbers("a1234bb11"));//1245
  }
}
