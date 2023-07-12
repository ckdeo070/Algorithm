import java.util.HashSet;

public class Solution {

  public boolean solution(String[] phone_book) {
    boolean answer = true;
    HashSet<String> set = new HashSet<>();
    for (String s : phone_book) {
      set.add(s);
    }
    for (int i = 0; i < phone_book.length; i++) {
      for (int j = 1; j < phone_book[i].length(); j++) {
        if(set.contains(phone_book[i].substring(0, j))) {
          return false;
        }
      }
    }
    return answer;
  }
}