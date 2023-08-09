class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        // step1
        new_id = new_id.toLowerCase();
        sb.append(new_id);
        
        // step2
        for(int i = 0; i < sb.length(); i++) {
        	char t = sb.charAt(i);
        	if(('a' <= t && t <= 'z') || ('0' <= t && t <= '9') || t == '-' || t == '_' || t == '.') {
        		continue;
        	}
        	else {
        		sb.deleteCharAt(i);
        		i--;
        	}
        }
        // step3
        int idx = 0;
        while((idx = sb.indexOf("..")) != -1) {
    		sb.replace(idx, idx+2, ".");
        }
        
        // step4
        if(sb.indexOf(".") == 0) {
        	sb.replace(0, 1, "");
        }
        if(sb.length() > 0 && sb.indexOf(".") == sb.length()-1) {
        	sb.replace(sb.length()-1, sb.length(), "");
        }
        
        // step5
        if(sb.length() == 0) {
        	sb.append("a");
        }
        
        // step6
        if(sb.length() > 15) {
        	sb.setLength(15);
        }
        if(sb.charAt(sb.length()-1) == '.') {
        	sb.replace(sb.length()-1, sb.length(), "");
        }
        
        // step7
        while(sb.length() < 3) {
        	sb.append(sb.substring(sb.length()-1, sb.length()));
        }
        
        return sb.toString();
    }
}