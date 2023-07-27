import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  Queue<Integer> queue = new LinkedList<>();
  boolean[] visit;
  int answer = 0;

  public int solution(int n, int[][] computers) {
    visit = new boolean[n];
    bfs(computers);
    return answer;
  }

  public void bfs(int[][] computers) {
    for (int i = 0; i < computers.length; i++) {
      int cur = i;
      if (!visit[cur]) {
        queue.add(cur);
        answer++;
      }
      while (!queue.isEmpty()) {
        cur = queue.poll();
        visit[cur] = true;
        for (int j = 0; j < computers[cur].length; j++) {
          int next = computers[cur][j];
          if (next == 1 && !visit[j]) {
            queue.add(j);
          }
        }
      }
    }
  }
}