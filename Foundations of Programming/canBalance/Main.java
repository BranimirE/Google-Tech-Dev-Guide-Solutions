import java.util.*;

public class Main {
  public boolean canBalance(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
    }
    boolean answer = false;
    if (sum % 2 == 0) {
      int target = sum / 2;
      sum = 0;
      for (int i = 0; i < nums.length && !answer; i++) {
        sum = sum + nums[i];
        if (sum == target) {
          answer = true;
        }
      }
    }
    return answer;
  }

  public static void main(String args[]) {
    Main main = new Main();
    System.out.println(main.canBalance(new int[] {1, 2, 3, 1, 0, 2, 3}));//true
  }
}
