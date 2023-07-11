import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, cnt = 0, cur = 0;
        int len = truck_weights.length;
        ArrayList<int[]> wait = new ArrayList<>();
        Queue<Integer> truck = new LinkedList<>();
        for (int i = 0; i < len; i++) {
          truck.add(truck_weights[i]);
        }
        while (cnt != len) {
          answer++;
          if (!truck.isEmpty()) {
            if (cur + truck.peek() <= weight) {
              cur += truck.peek();
              wait.add(new int[]{bridge_length, truck.peek()});
              truck.poll();
            }
          }
          Iterator<int[]> iterator = wait.iterator();
          while (iterator.hasNext()) {
            int[] m = iterator.next();
            m[0]--;
            if (m[0] == 0) {
              cur -= m[1];
              cnt++;
              iterator.remove();
            }
          }
        }
    return ++answer;
    }
}