import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int getParent(int[] parent, int n) {
    if (parent[n] == n) {
      return n;
    }
    return parent[n] = getParent(parent, parent[n]);
  }

  public void unionParent(int[] parent, int a, int b) {
    a = getParent(parent, a);
    b = getParent(parent, b);
    if (a < b) {
      parent[b] = a;
    } else {
      parent[a] = b;
    }
  }

  public int solution(int n, int[][] costs) {
    int answer = 0;
    int[] parents = new int[n];
    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }
    Arrays.sort(costs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[2] - o2[2];
      }
    });

    for (int[] cost : costs) {
      if (getParent(parents, cost[0]) == getParent(parents, cost[1])) {
        continue;
      } else {
        unionParent(parents, cost[0], cost[1]);
        answer += cost[2];
      }
    }

    return answer;
  }
}