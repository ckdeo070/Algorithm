public class Solution {

  int cnt = 0, len, t;

  public int solution(int[] numbers, int target) {
    len = numbers.length;
    t = target;
    search(numbers, 0, 0);
    return cnt;
  }

  public void search(int[] numbers, int sum, int depth) {
    if (depth == len) {
      if (sum == t) {
        cnt++;
      }
      return;
    }
    search(numbers, sum + numbers[depth], depth + 1);
    search(numbers, sum - numbers[depth], depth + 1);
  }
}