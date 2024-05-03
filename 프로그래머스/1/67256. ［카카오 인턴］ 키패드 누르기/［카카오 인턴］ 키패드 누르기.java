class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] r = new int[] {3, 0};
        int[] l = new int[] {3, 2};
        
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                l[0] = number / 3;
                l[1] = 0;
                answer += "L";
            } else if (number == 3 || number == 6 || number == 9) {
                r[0] = number / 3 - 1;
                r[1] = 2;
                answer += "R";
            } else {
                if (calDistance(l, number) > calDistance(r, number)) {
                    answer += "R";
                    handPosition(r, number);
                } else if (calDistance(l, number) < calDistance(r, number)) {
                    answer += "L";
                    handPosition(l, number);
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        handPosition(l, number);
                    } else {
                        answer += "R";
                        handPosition(r, number);
                    }
                }
            }
        }
        return answer;
    }
    
    public int calDistance(int[] p, int num) {
        int tX;
        if (num == 0) {
            tX = 3;
        } else {
            tX = num / 3;
        }
        int tY = 1;
        return Math.abs(p[0] - tX) + Math.abs(p[1] - tY);
    }
    
    public void handPosition(int[] p, int num) {
        if (num == 0) {
            p[0] = 3;
        } else {
            p[0] = num / 3;
        }
        p[1] = 1;
    }
}