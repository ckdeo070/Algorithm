class Solution {
    public int[] solution(int[] prices) {
       int len = prices.length - 1;
    int[] result = new int[len + 1];
    int min = 10001, idx = 0;
    for (int i = len; i >= 0; i--) {
      if (prices[i] <= min) {
        min = prices[i];
        idx = i;
        result[i] = len - idx;
      } else {
        for (int j = i + 1; j <= idx; j++) {
          if (prices[j] < prices[i]) {
            result[i] = j - i;
              break;
          }
        }
      }
    }
    return result;
    }
}