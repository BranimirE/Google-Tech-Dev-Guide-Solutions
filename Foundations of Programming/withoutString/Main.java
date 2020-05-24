import java.util.*;

public class Main {
  public String withoutString(String base, String remove) {
    int n = base.length(), m = remove.length();
    boolean mantains[] = new boolean[n];
    Arrays.fill(mantains, true);
    for (int i = 0; i + m <= n; i++) {
      boolean found = true;
      for (int j = 0; j < m && found; j++) {
        char a = Character.toLowerCase(base.charAt(i+j));
        char b = Character.toLowerCase(remove.charAt(j));
        if (a != b) {
          found = false;
        }
      }
      if (found) {
        for (int j = 0; j < m; j++) {
          mantains[i+j] = false;
        }
        i = i + m - 1;
      }
    }
    StringBuffer answer = new StringBuffer();
    for (int i = 0; i < n; i++) {
      if (mantains[i]) {
        answer.append(base.charAt(i));
      }
    }
    return answer.toString();
  }

  public static void main(String args[]) {
    Main main = new Main();
    System.out.println(main.withoutString("abxxxxab", "xx"));
  }
}
