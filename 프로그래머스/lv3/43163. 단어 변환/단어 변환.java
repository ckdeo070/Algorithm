public class Solution {

  boolean[] visit;
  int min = 0;

  public int solution(String begin, String target, String[] words) {
    visit = new boolean[words.length];
    dfs(words, begin, target, 0);
    return min;
  }

  public void dfs(String[] words, String word, String target, int depth) {
    if (word.equals(target)) {
      if (min != 0) {
        min = Math.min(min, depth);
      }
      else {
        min = depth;
      }
      return;
    }

    for (int i = 0; i < words.length; i++) {
      if (!visit[i]){
        if (oneAlphabetDiff(word, words[i])) {
          visit[i] = true;
          dfs(words, words[i], target, depth + 1);
          visit[i] = false;
        }
      }
    }
  }

  public boolean oneAlphabetDiff (String s1, String s2) {
    int cnt = 0;
    for (int i = 0; i < s1.length(); i++) {
      char a = s1.charAt(i);
      char b = s2.charAt(i);
      if (a != b) {
        cnt++;
      }
    }
    if (cnt == 1) {
      return true;
    }
    return false;
  }
}