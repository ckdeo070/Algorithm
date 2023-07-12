import java.util.HashSet;

public class Solution {

  public int solution(int[] nums) {
    int answer = 0;
    HashSet<Integer> set = new HashSet<>();
    for (int n : nums) {
      set.add(n);
    }
    if (set.size() >= nums.length / 2) {
      return nums.length / 2;
    } else {
      return set.size();
    }
  }
}