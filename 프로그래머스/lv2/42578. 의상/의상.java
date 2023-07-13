import java.util.*;

public class Solution {

  ArrayList<Integer> list = new ArrayList<>();
  int sum = 0;

  public int solution(String[][] clothes) {
    HashMap<String, Integer> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < clothes.length; i++) {
      if (!set.contains(clothes[i][0])) {
        set.add(clothes[i][0]);
        map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
      }
    }
    for (String s : map.keySet()) {
      list.add(map.get(s));
    }
    search(0, 1, 0);

    return --sum;
  }

  public void search(int start, int cur, int depth) {
    if (depth == list.size()) {
      sum += cur;
      return;
    }
    for (int i = start; i < list.size(); i++) {
      search(i + 1, cur * list.get(i), depth + 1);
      search(i + 1, cur * 1, depth + 1);
      return;
    }
  }
}