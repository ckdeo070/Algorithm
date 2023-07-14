import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

  public int[] solution(int[] array, int[][] commands) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < commands.length; i++) {
      int start = commands[i][0];
      int end = commands[i][1];
      int[] temp = new int[end - start + 1];
      for (int j = 0; j <= end - start; j++) {
        temp[j] = array[start + j - 1];
      }
      Arrays.sort(temp);
      result.add(temp[commands[i][2] - 1]);
    }
    int[] answer = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      answer[i] = result.get(i);
    }
    return answer;
  }
}