import java.util.Scanner;

public class Main {

  static int N, cnt = 0;
  static int[][] queen;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    queen = new int[N][N];

    dfs(0);
    System.out.println(cnt);
  }

  public static void dfs(int depth) {
    if (depth == N) {
      cnt++;
      return;
    }

    for (int i = 0; i < N; i++) {
      boolean isPos = true;
      for (int j = 1; j <= depth; j++) {
        // 위에 검증
        if (queen[depth - j][i] == 1) {
          isPos = false;
          break;
        }
        // 왼쪽 대각 검증
        if (i - j >= 0 && queen[depth - j][i - j] == 1) {
          isPos = false;
          break;
        }
        // 오른쪽 대각 검증
        if (i + j < N && queen[depth - j][i + j] == 1) {
          isPos = false;
          break;
        }
      }
      if (isPos) {
        queen[depth][i] = 1;
        dfs(depth + 1);
        queen[depth][i] = 0;
      }
    }
  }
}