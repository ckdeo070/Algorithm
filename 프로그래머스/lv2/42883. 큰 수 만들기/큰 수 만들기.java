public class Solution {

  public String solution(String number, int k) {
    StringBuilder sb = new StringBuilder();
    sb.append(number);
    int cnt = 0, idx = 0;
      
    while (cnt != k) {
      int len = sb.length();
      if (idx == len - 1) {
        sb.deleteCharAt(idx);
        cnt++;
        idx--;
      } else if (sb.charAt(idx) < sb.charAt(idx + 1)) {
        sb.deleteCharAt(idx);
        cnt++;
        if (idx > 0) {
          idx--;
        }
      } else {
        idx++;
      }
    }

    return sb.toString();
  }
}