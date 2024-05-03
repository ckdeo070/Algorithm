class Solution {
    public int solution(int[] ingredient) {
        int result = 0;
        int[] stack = new int[ingredient.length];
        int sp = 0;
        for (int num : ingredient) {
            stack[sp] = num;
            if (sp >= 3 && stack[sp] == 1 && stack[sp - 1] == 3 
                && stack[sp - 2] == 2 && stack[sp - 3] == 1) {
                sp -= 3;
                result++;
            } else {
                sp++;                
            }
        }
        
        return result;
    }
}