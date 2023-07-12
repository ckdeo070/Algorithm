import java.util.ArrayList;

class Solution {
  ArrayList<Integer>[] list;
  boolean[] visit;
  int num1, num2;

  public int solution(int n, int[][] wires) {
    int answer = 100;
    list = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }
    for (int i = 0; i < wires.length; i++) {
      int a = wires[i][0];
      int b = wires[i][1];
      list[a].add(b);
      list[b].add(a);
    }
    for (int i = 0; i < wires.length; i++) {
      num1 = num2 = 0;
      visit = new boolean[n + 1];
      visit[wires[i][0]] = visit[wires[i][1]] = true;
      dfs(wires[i][0], 0);
      dfs(wires[i][1], 1);
      int val = Math.abs(num1 - num2);
      if (val < answer) {
        answer = val;
      }
    }

    return answer;
  }

  public void dfs(int idx, int n) {
    for (int i = 0; i < list[idx].size(); i++) {
      if (!visit[list[idx].get(i)]) {
        if (n == 0) {
          num1++;
        } else {
          num2++;
        }
        visit[list[idx].get(i)] = true;
        dfs(list[idx].get(i), n);
      }
    }
  }
}