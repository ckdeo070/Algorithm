public class Main {

  static boolean[] dp = new boolean[10001];

  private static void fillDp(int num) {
    while (num <= 10000) {
      int n = num;
      while (n > 0) {
        num += n % 10;
        n /= 10;
      }
      if (num > 10000 || dp[num]) {
        return;
      }
      dp[num] = true;
    }
  }

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();

    for (int i = 1; i <= 10000; i++) {
      if (!dp[i]) {
        fillDp(i);
      }
    }

    for (int i = 1; i <= 10000; i++) {
      if (!dp[i]) {
        sb.append(i + "\n");
      }
    }

    System.out.println(sb);
  }

}