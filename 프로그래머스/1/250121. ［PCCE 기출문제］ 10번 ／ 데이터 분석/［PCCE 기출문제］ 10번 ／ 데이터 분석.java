import java.util.*;

class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        HashMap<String, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int extIndex = map.get(ext);
        for (int[] extData : data) {
            if(extData[extIndex] < val_ext) {
                list.add(extData);
            }
        }
        
        int sortIndex = map.get(sort_by);
        Collections.sort(list, (o1, o2) -> o1[sortIndex] - o2[sortIndex]);
        
        return list;
    }
}