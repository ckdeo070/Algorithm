import java.util.Scanner;

public class Main {

  static int N, M;
  static int[] arr;
  static boolean[] visit;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    arr = new int[M];
    visit = new boolean[N + 1];

    search(0);
    System.out.println(sb);
  }

  public static void search(int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        if (i == M - 1) {
          sb.append(arr[i] + "\n");
        } else {
          sb.append(arr[i] + " ");
        }
      }
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (!visit[i]) {
        if (depth != 0 && arr[depth - 1] > i) {
          continue;
        }
        arr[depth] = i;
        visit[i] = true;
        search(depth + 1);
        visit[i] = false;
      }
    }
  }
}