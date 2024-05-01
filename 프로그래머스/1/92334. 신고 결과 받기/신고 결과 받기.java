import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> set = new HashSet<>();
        for (String r : report) {
            set.add(r);
        }
        
        HashMap<String, Integer> indexMap = new HashMap<>();
        HashMap<String, Integer> countMap = new HashMap<>();
        int index = 0;
        for (String id : id_list) {
            indexMap.put(id, index++);
            countMap.put(id, 0);
        }
        
        int len = id_list.length;
        List[] list = new List[len];
        for (int i = 0; i < len; i++) {
            list[i] = new ArrayList<String>();
        }
        
        for (String r : set) {
            String[] id = r.split(" ");
            list[indexMap.get(id[0])].add(id[1]);
            countMap.put(id[1], countMap.get(id[1]) + 1);
        }
        
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                if (countMap.get(list[i].get(j)) >= k) {
                    answer[i]++;
                }
            }
        }
        
		return answer;
    }
}