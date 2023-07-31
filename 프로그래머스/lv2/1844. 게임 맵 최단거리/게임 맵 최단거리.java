import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  int[] dx = {0, 1, 0, -1};
  int[] dy = {1, 0, -1, 0};
  Queue<int[]> queue = new LinkedList<>();
  boolean[][] visit;
  int n, m, min = -1, cnt;

  public int solution(int[][] maps) {
    n = maps.length;
    m = maps[0].length;
    visit = new boolean[n][m];
    bfs(maps, 0, 0);
    return min;
  }

  public void bfs(int[][] maps, int x, int y) {
    queue.add(new int[]{x, y, 1});
    visit[x][y] = true;

    while (!queue.isEmpty()) {
      int[] temp = queue.poll();
      x = temp[0];
      y = temp[1];
      cnt = temp[2];
      for (int i = 0; i < 4; i++) {
        int dX = x + dx[i];
        int dY = y + dy[i];
        if (dX >= 0 && dX < n && dY >= 0 && dY < m) {
          if (!visit[dX][dY] && maps[dX][dY] == 1) {
            if (dX == n - 1 && dY == m - 1) {
              min = ++cnt;
              return;
            }
            visit[dX][dY] = true;
            queue.add(new int[]{dX, dY, cnt + 1});
          }
        }
      }
    }
  }
}