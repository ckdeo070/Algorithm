import java.util.Scanner;

public class Main {

  static int[] num;
  static int max = 0, N, M;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    num = new int[N];
    for (int i = 0; i < N; i++) {
      num[i] = Integer.parseInt(sc.next());
    }

    dfs(0, 0, 0);
    
    System.out.println(max);
  }

  public static void dfs(int start, int sum, int depth) {
    if (sum > M || depth > 3) {
      return;
    }
    if (depth == 3 && sum > max) {
      max = sum;
      return;
    }
    for (int i = start + 1; i < N; i++) {
        dfs(i, sum + num[i], depth + 1);
      }
    }
}