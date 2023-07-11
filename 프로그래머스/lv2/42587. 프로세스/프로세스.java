import java.util.LinkedList;
class Solution {
    public int solution(int[] priorities, int location) {
        LinkedList<int[]> list = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
        	list.add(new int[] {i, priorities[i]});
        }
        int cnt = 1, max = -1, idx = 0;
        while(!list.isEmpty()) {
        	max = -1;
        	for(int i = 0; i < list.size(); i++) {
        		if(max < list.get(i)[1]) {
        			idx = i;
        			max = list.get(i)[1];
        		}
        	}
        	while(idx-- > 0) {
        		list.add(list.get(0));
        		list.poll();
        	}
        	if(list.get(0)[0] == location) {
        		return cnt;
        	}
        	cnt++;
        	list.poll();
        }
        return cnt;
    }
}