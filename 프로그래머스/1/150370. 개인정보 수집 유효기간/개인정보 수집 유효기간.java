import java.util.*;
class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }
        List<Integer> list = new ArrayList<>();
        int tDay = convertDay(today);
        int index = 1;
        for(String privacy : privacies) {
            String[] p = privacy.split(" ");
            int pDay = convertDay(p[0]);
            pDay += map.get(p[1]) * 28;
            if (pDay <= tDay) {
                list.add(index);
            }
            index++;
        }
        
        return list;
    }
    
    public int convertDay(String date) {
        String[] d = date.split("\\.");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        month += year * 12;
        day += month * 28;
        
        return day;
    }
}