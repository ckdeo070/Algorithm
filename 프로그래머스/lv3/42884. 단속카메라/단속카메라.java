import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int solution(int[][] routes) {
    int answer = 0;
    for (int i = 0; i < routes.length; i++) {
      if (routes[i][0] > routes[i][1]) {
        int temp = routes[i][0];
        routes[i][0] = routes[i][1];
        routes[i][1] = temp;
      }
    }
    Arrays.sort(routes, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    int idx = 0;
    while (idx != routes.length) {
      int cur = routes[idx][1];
      while (true) {
        idx++;
        if (idx >= routes.length) {
          return ++answer;
        }
        if (cur >= routes[idx][0]) {
          if (cur > routes[idx][1]) {
            cur = routes[idx][1];
          }
        } else {
          answer++;
          break;
        }
      }
    }
    return answer;
  }
}