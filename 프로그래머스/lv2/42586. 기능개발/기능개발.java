import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = progresses.length;
        int[] day = new int[len];
        for(int i = 0; i < len; i++) {
        	int cnt = 1;
        	int idx = 1;
        	int temp = 100 - progresses[i]; 
        	while(true) {
        		if(temp <= idx*speeds[i]) {
        			break;
        		}
        		cnt++;
        		idx++;
        	}
        	day[i] = cnt;
        }
        int temp = day[0];
        int cnt = 1;
        for(int i = 1; i < len; i++) {
        	int num = day[i];
        	if(i == (len-1)) {
        		if(temp < num) {
        			list.add(cnt);
        			list.add(1);
        		}
        		else {
        			list.add(++cnt);
        		}
        		break;
        	}
        	if(temp < num) {
        		list.add(cnt);
        		cnt = 1;
        		temp = num;
        	}
        	else {
        		cnt++;
        	}
        }
        int size = list.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
}