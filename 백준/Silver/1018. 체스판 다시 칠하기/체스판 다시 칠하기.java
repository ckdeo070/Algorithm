import java.util.Scanner;

public class Main {

  static int min = Integer.MAX_VALUE;
  static char[][] board;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    // 보드 채우기
    board = new char[N][M];
    for (int i = 0; i < N; i++) {
      String s = sc.next();
      for (int j = 0; j < M; j++) {
        board[i][j] = s.charAt(j);
      }
    }

    // 칠해야하는 경우의 수 탐색
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (i + 8 <= N && j + 8 <= M) {
          search(i, j);
        }
      }
    }
    System.out.println(min);
  }

  public static void search(int row, int col) {
    int blackCount = 0, whiteCount = 0;
    boolean black = false, white = false;

    for (int i = row; i < row + 8; i++) {
      black = !black;
      white = !white;
      for (int j = col; j < col + 8; j++) {

        // 'BWBWBWBW' 경우의 수
        if (black) {
          if (board[i][j] != 'B') {
            blackCount++;
          }
          black = false;
        }
        else {
          if (board[i][j] != 'W') {
            blackCount++;
          }
          black = true;
        }

        // 'WBWBWBWB' 경우의 수
        if (white) {
          if (board[i][j] != 'W') {
            whiteCount++;
          }
          white = false;
        }
        else {
          if (board[i][j] != 'B') {
            whiteCount++;
          }
          white = true;
        }
      }
    }

    // 2가지 경우 중 더 작은 경우수 선택
    min = Integer.min(min, Integer.min(blackCount, whiteCount));
  }
}
