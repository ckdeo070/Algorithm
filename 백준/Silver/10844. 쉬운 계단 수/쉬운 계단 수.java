import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		long[][] dp = new long[101][10];
		long sum = 0;
		int div = 1000000000;
		for(int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		int N = sc.nextInt();
		for(int i = 2; i <= N; i++) {
			dp[i][0] = dp[i-1][1];
			for(int j = 1; j <= 9; j++) {
				if(j == 9) {
					dp[i][j] = dp[i-1][j-1] % div;
					continue;
				}
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % div;
			}
		}
		for(int i = 1; i <= 9; i++) {
			sum += dp[N][i];
		}
		System.out.println(sum % div);
	}
}