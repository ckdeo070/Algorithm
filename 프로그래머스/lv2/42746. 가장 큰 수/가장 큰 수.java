import java.util.*;

public class Solution {

  public String solution(int[] numbers) {
    String answer = "";
    ArrayList<String> list = new ArrayList<>();
    for (int i = 0; i < numbers.length; i++) {
      list.add(Integer.toString(numbers[i]));
    }

    Collections.sort(list, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) {
          return o2.compareTo(o1);
        }
        String s1 = o1 + o2;
        String s2 = o2 + o1;
        return s2.compareTo(s1);
      }
    });

    for (String s : list) {
      if (answer.equals("0")) {
        return "0";
      }
      answer += s;
    }
    return answer;
  }
}