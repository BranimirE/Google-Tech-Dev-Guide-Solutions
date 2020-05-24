public class Main {
  public int maxSpan(int[] nums) {
    int best = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          best = Math.max(best, j-i+1);
        }
      }
    }
    return best;
  }

  public static void main(String args[]) {
    Main main = new Main();
    System.out.println(main.maxSpan(new int[] {1, 4, 2, 1, 4, 4, 4}));
  }
}
