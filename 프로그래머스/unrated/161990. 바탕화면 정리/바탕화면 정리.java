class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        int f_x = row, f_y = col, l_x = 0, l_y = 0;
        char[][] map = new char[row][col];
        for(int i = 0; i < row; i++){
            String S = wallpaper[i];
            for(int j = 0; j < col; j++){
                if(S.charAt(j) == '#'){
                    if(i < f_x){
                        f_x = i;
                    }
                    if(j < f_y){
                        f_y = j;
                    }
                    if(i > l_x){
                        l_x = i;
                    }
                    if(j > l_y){
                        l_y = j;
                    }
                }
            }
        }
        answer[0] = f_x;
        answer[1] = f_y;
        answer[2] = l_x+1;
        answer[3] = l_y+1;
        return answer;
    }
}