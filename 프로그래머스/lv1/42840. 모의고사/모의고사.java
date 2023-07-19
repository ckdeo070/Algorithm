import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int max = 0;
        int[] Math1 = {1, 2, 3, 4, 5};
        int[] Math2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] Math3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i = 0; i < answers.length; i++) {
        	int a = answers[i];
        	if(a == Math1[i%5]) {
        		answer[0]++;
        	}
        	if(a == Math2[i%8]) {
        		answer[1]++;
        	}
        	if(a == Math3[i%10]) {
        		answer[2]++;
        	}
        }
        max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
        	if(max == answer[i]) {
        		list.add(i);
        	}
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++) {
        	result[i] = list.get(i)+1;
        }
        return result;
    }
}