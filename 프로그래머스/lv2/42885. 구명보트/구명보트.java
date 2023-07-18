public class Solution {

  public int solution(int[] people, int limit) {
    int answer = 0;
    int[] weight = new int[241];
    for (int i = 0; i < people.length; i++) {
      weight[people[i]]++;
    }
      
    int idx = 40;
    while (idx <= limit) {
      if (weight[idx] <= 0) {
        idx++;
      } else {
        if (idx > limit / 2) {
          weight[idx]--;
          answer++;
          continue;
        }
        for (int i = limit; i >= idx; i--) {
          if (weight[i] != 0) {
            if (i + idx <= limit) {
              weight[i]--;
              weight[idx]--;
              answer++;
              break;
            }
          }
        }
      }
    }
      
    return answer;
  }
}