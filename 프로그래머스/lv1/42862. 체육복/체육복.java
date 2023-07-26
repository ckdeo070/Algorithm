import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
		int cur, next = 0, prev = 0;
        ArrayList<Integer> lostList = new ArrayList<>();
        ArrayList<Integer> reserveList = new ArrayList<>();
        
        for(int i = 0; i < lost.length; i++) {
        	lostList.add(lost[i]);
        }
        for(int i = 0; i < reserve.length; i++) {
        	int num = reserve[i];
        	if(lostList.contains(num)) {
        		lostList.remove((Integer)num);
        		answer++;
        	}
        	else {
        		reserveList.add(num);
        	}
        }        
        Collections.sort(lostList);
        for(int i = 0; i < lostList.size(); i++) {
        	cur = lostList.get(i);
        	if(reserveList.contains(cur - 1)) {
        		answer++;
        		reserveList.remove((Integer)(cur - 1));
        	}
        	else if(reserveList.contains(cur + 1)){
        		answer++;
        		reserveList.remove((Integer)(cur + 1));
        	}
        	
        }
        return answer;
    }
}