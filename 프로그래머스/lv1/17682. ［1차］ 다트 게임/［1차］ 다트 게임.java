class Solution {
    char prevSign=0;
	public int solution(String dartResult) {
        int answer = 0, idx = 0, cnt = 0;
        String[] Dart = new String[3];
        char[] Sign = new char[3];
        for(int i = 0; i < dartResult.length(); i++) {
        	char t = dartResult.charAt(i);
        	if(t == 'S' || t == 'D' || t == 'T') {
        		Dart[cnt] = dartResult.substring(idx, i+1);
        		idx = i+1;
        		cnt++;
        	}
        	if(t == '*' || t == '#') {
        		Sign[cnt-1] = t;
        		idx++;
        	}
        }
        
        for(int i = 2; i >= 0; i--) {
        	int len = Dart[i].length();
        	int num = Integer.parseInt(Dart[i].substring(0, len-1));
        	char s = Dart[i].charAt(len-1);
        	char curSign = Sign[i];
        	if(s == 'S') {
        		num = cal(curSign, num);
        	}
        	else if(s == 'D') {
        		num = (int) Math.pow(num, 2);
        		num = cal(curSign, num);
        	}
        	else {
        		num = (int) Math.pow(num, 3);
        		num = cal(curSign, num);
        		
        	}
        	answer += num;
        }
        
        return answer;
    }
	public int cal(char cur, int num) {
		if(prevSign != 0) {
			if(prevSign == '*') {
				num *= 2;
				prevSign=0;
			}
		}
		if(cur != 0) {
			if(cur == '*') {
				num *= 2;
				prevSign = '*';
			}
			else if(cur == '#') {
				num *= -1;
			}
		}
		return num;
	}
}