import java.util.*;

class Solution {
    int depth;
    int max = -1;
    int[] result = new int[11];
    Set<String> set = new HashSet<>();
    
    public int[] solution(int n, int[] info) {
        int[] lian = new int[11];
        depth = n;
        search(0, lian, info);
        
        if (max == -1 || max == 0) {
            return new int[]{-1};
        }
        
        return result;
    }
    
    public void search(int cnt, int[] lian, int[] apeach) {
        if (cnt == depth) {
            int score = calScore(lian, apeach);
            if (max < score) {
                max = score;
                result = lian.clone();
            }
            if (max == score) {
                compScore(lian);
            }
            return;
        }
        
        for (int i = 0; i < 11; i++) {
                lian[i]++;
            if (isVisit(lian)) {
                search(cnt + 1, lian, apeach);
            }
                lian[i]--;    
        }
    }
    
    public int calScore(int[] lian, int[] apeach) {
        int lianScore = 0;
        int apeachScore = 0;
        for (int i = 0; i < 11; i++) {
            int score = 10 - i;
            if (lian[i] == 0 && apeach[i] == 0) {
                continue;
            }
            if (lian[i] > apeach[i]) {
                lianScore += score;
            } else {
                apeachScore += score;
            }
        }
        
        return lianScore - apeachScore;
    }
    
    public void compScore(int[] lian) {
        for(int i = 10; i >= 0; i--) {
            if (lian[i] > result[i]) {
                result = lian.clone();
                return;
            }
            if (result[i] > lian[i]) {
                return;
            }
        }
    }
    
    public boolean isVisit(int[] lian) {
        StringBuilder sb = new StringBuilder();
        for(int num : lian) {
            sb.append(num);
        }
        if (set.contains(sb.toString())) {
            return false;
        }
        set.add(sb.toString());
        return true;
    }
}