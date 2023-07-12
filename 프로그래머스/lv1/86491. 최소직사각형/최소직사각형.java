class Solution {
    public int solution(int[][] sizes) {
        int answer = 0, maxW = 0, row = 0, col = 0, maxH = 0;
        for(int i = 0; i < sizes.length; i++) {
        	for(int j = 0; j < 2; j++) {
        		if(sizes[i][j] > maxW) {
        			maxW = sizes[i][j];
        			col = j;
        			row = i;
        		}
        	}
        }
        if(col == 1) {
        	swap(sizes, row);
        }
        for(int i = 0; i < sizes.length; i++) {
        	if(sizes[i][0] < sizes[i][1]) {
        		swap(sizes, i);
        	}
        	if(maxH < sizes[i][1]) {
        		maxH = sizes[i][1];
        	}
        }
        answer = maxW * maxH;
        return answer;
    }
	
	public void swap(int[][] sizes, int row) {
		int temp = sizes[row][1];
		sizes[row][1] = sizes[row][0];
		sizes[row][0] = temp;
	}
}