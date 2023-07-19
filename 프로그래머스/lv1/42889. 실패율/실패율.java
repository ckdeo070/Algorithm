import java.util.HashMap;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int s : stages) {
        	map.put(s, map.getOrDefault(s, 0)+1);
        }
        int sum = stages.length;
        double[] fail = new double[N+1];
        for(int i = 1; i <= N; i++) {
        	double curStage = map.getOrDefault(i, 0);
        	if(sum == 0) {
        		fail[i] = 0;
        	}
        	else {
        		fail[i] = curStage/sum;
        	}
        	sum -= curStage;
        }
        for(int i = 1; i <= N; i++) {
        	double max = -1;
        	int idx = 0;
        	for(int j = 1; j <= N; j++) {
        		if(fail[j] > max) {
        			max = fail[j];
        			idx = j;
        		}
        	}
        	fail[idx] = -1;
        	answer[i-1] = idx;
        }
        return answer;
    }
}