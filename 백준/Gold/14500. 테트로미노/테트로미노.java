import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int t1(int[][] M) {
		int max = 0;
		int num1, num2;
		for(int i = 0; i < M.length; i++) {
			for(int j = 0; j < M[i].length-3; j++) {
				num1 = M[i][j] + M[i][j+1] + M[i][j+2] + M[i][j+3];
				if(max < num1) {
					max = num1;
				}
			}
		}
		for(int i = 0; i < M.length - 3; i++) {
			for(int j = 0; j < M[i].length; j++) {
				num2 = M[i][j] + M[i+1][j] + M[i+2][j] + M[i+3][j];
				if(max < num2) {
					max = num2;
				}
			}
		}
		return max;
	}
	public static int t2(int[][] M) {
		int max = 0;
		int num1;
		for(int i = 0; i < M.length-1; i++) {
			for(int j = 0; j < M[i].length-1; j++) {
				num1 = M[i][j] + M[i][j+1] + M[i+1][j] + M[i+1][j+1];
				if(max < num1) {
					max = num1;
				}
			}
		}
		return max;
	}
	public static int t3(int[][] M) {
		int max = 0;
		int num1, num2, num3, num4, num5, num6, num7, num8;
		for(int i = 0; i < M.length-2; i++) {
			for(int j = 0; j < M[i].length-1; j++) {
				num1 = M[i][j] + M[i+1][j] + M[i+2][j] + M[i+2][j+1];
				num2 = M[i][j+1] + M[i+1][j+1] + M[i+2][j+1] + M[i+2][j];
				num3 = M[i][j] + M[i+1][j] + M[i+1][j+1] + M[i+2][j+1];
				num4 = M[i][j+1] + M[i+1][j+1] + M[i+1][j] + M[i+2][j];
				num5 = M[i][j+1] + M[i+1][j+1] + M[i+1][j] + M[i+2][j+1];
				num6 = M[i][j] + M[i+1][j] + M[i+2][j] + M[i+1][j+1];
				num7 = M[i][j] + M[i][j+1] + M[i+1][j] + M[i+2][j];
				num8 = M[i][j] + M[i][j+1] + M[i+1][j+1] + M[i+2][j+1];
				if(max < Math.max(num1, num2)) {
					max = Math.max(num1, num2);
				}
				if(max < Math.max(num3, num4)) {
					max = Math.max(num3, num4);
				}
				if(max < Math.max(num5, num6)) {
					max = Math.max(num5, num6);
				}
				if(max < Math.max(num7, num8)) {
					max = Math.max(num7, num8);
				}
			}
		}
		return max;
	}
	public static int t4(int[][] M) {
		int max = 0;
		int num1, num2, num3, num4, num5, num6, num7, num8;
		for(int i = 0; i < M.length-1; i++) {
			for(int j = 0; j < M[i].length-2; j++) {
				num1 = M[i+1][j] + M[i+1][j+1] + M[i+1][j+2] + M[i][j+2];
				num2 = M[i][j] + M[i+1][j] + M[i+1][j+1] + M[i+1][j+2];
				num3 = M[i+1][j] + M[i+1][j+1] + M[i][j+1] + M[i][j+2];
				num4 = M[i][j] + M[i][j+1] + M[i+1][j+1] + M[i+1][j+2];
				num5 = M[i+1][j] + M[i+1][j+1] + M[i][j+1] + M[i+1][j+2];
				num6 = M[i][j] + M[i][j+1] + M[i][j+2] + M[i+1][j+1];
				num7 = M[i][j] + M[i][j+1] + M[i][j+2] + M[i+1][j];
				num8 = M[i][j] + M[i][j+1] + M[i][j+2] + M[i+1][j+2];
				if(max < Math.max(num1, num2)) {
					max = Math.max(num1, num2);
				}
				if(max < Math.max(num3, num4)) {
					max = Math.max(num3, num4);
				}
				if(max < Math.max(num5, num6)) {
					max = Math.max(num5, num6);
				}
				if(max < Math.max(num7, num8)) {
					max = Math.max(num7, num8);
				}
			}
		}
		return max;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int num1, num2;
		int[][] num = new int[N][M];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		num1 = Math.max(t1(num), t2(num));
		num2 =  Math.max(t3(num), t4(num));
		System.out.println(Math.max(num1, num2));
	}
}