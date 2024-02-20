import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[M];
		visit = new boolean[N];
		dfs(N, M, 0);
		System.out.println(sb);
	}
	
	static void dfs(int N, int M, int depth) {
		
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visit[i]) {
				arr[depth] = i+1;
				visit[i] = true;
				dfs(N, M, depth+1);
				visit[i] = false;
			}
		}
	}
}