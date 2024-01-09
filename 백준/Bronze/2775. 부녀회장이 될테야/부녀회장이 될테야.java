import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    int[][] dp = new int[15][15];
    fillDp(dp);

    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int k = sc.nextInt();
      int n = sc.nextInt();

      System.out.println(dp[k][n]);
    }
  }

  private static void fillDp(int[][] dp) {
    for (int i = 0; i <= 14; i++) {
      for (int j = 0; j <= 14; j++) {
        int sum = 0;
        if (i == 0) {
          dp[i][j] = j;
        } else {
          for (int k = 0; k <= j; k++) {
            sum += dp[i-1][k];
          }
          dp[i][j] = sum;
        }
      }
    }
  }
}