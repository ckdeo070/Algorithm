public class Solution {

  public int solution(String name) {
    int answer = 0;
    int len = name.length();
    int cursor = len - 1;
    for (int i = 0; i < len; i++) {
      char c = name.charAt(i);
      answer += Math.min(c - 'A', 'Z' - c + 1);

      int next = i + 1;
      while (next < len && name.charAt(next) == 'A') {
        next++;
      }

      cursor = Math.min(cursor, i * 2 + (len - next));
      cursor = Math.min(cursor, (len - next) * 2 + i);
    }
    return answer + cursor;
  }
}