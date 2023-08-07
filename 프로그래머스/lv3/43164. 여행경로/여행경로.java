import java.util.*;

public class Solution {

  String[] answer;
  HashMap<String, ArrayList<String>> map = new HashMap<>();
  HashMap<String, ArrayList<Boolean>> visit = new HashMap<>();
  int n;

  public String[] solution(String[][] tickets) {
    for (String[] t : tickets) {
      if (!map.containsKey(t[0])) {
        map.put(t[0], new ArrayList<>());
        visit.put(t[0], new ArrayList<>());
      }
      map.get(t[0]).add(t[1]);
      visit.get(t[0]).add(false);
    }

    for (String s : map.keySet()) {
      Collections.sort(map.get(s));
    }

    n = tickets.length;
    answer = new String[n + 1];
    answer[0] = "ICN";

    dfs("ICN", 1);

    return answer;
  }

  public void dfs(String curPort, int depth) {
    if (!map.containsKey(curPort)) {
      return;
    }

    ArrayList<String> portInfo = map.get(curPort);
    ArrayList<Boolean> visitInfo = visit.get(curPort);
    for (int i = 0; i < portInfo.size(); i++) {
      if (answer[n] != null) {
        return;
      }
      if (!visitInfo.get(i)) {
        String nextPort = portInfo.get(i);
        answer[depth] = nextPort;
        visitInfo.set(i, true);
        dfs(nextPort, depth + 1);
        visitInfo.set(i, false);
      }
    }
  }
}