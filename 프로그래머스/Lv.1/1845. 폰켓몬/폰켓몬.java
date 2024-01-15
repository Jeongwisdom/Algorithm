import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> pokemon = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            pokemon.add(nums[i]);
        }
        int answer = Math.min(nums.length / 2, pokemon.size());
        return answer;
    }
}