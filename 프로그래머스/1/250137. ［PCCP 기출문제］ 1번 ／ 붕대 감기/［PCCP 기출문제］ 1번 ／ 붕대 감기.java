import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int curTime = 0;
        int conTime = 0;
        int curHealth = health;
        for (int[] attack : attacks) {
            for (int i = curTime; i < attack[0]; i++) {
                curTime++;
                conTime++;
                if (curHealth < health) {
                    curHealth += bandage[1];
                    if (curHealth > health) {
                        curHealth = health;
                    }
                }
                if (conTime == bandage[0]) {
                    curHealth += bandage[2];
                    conTime = 0;
                    if (curHealth > health) {
                        curHealth = health;
                    }
                }
            }
            curHealth -= attack[1];
            if (curHealth <= 0) {
                return -1;
            }
            curTime++;
            conTime = 0;
        }
        
        return curHealth;
    }
}