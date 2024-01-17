class Solution {
    int answer = 0;
    
    public int solution(int[] nums) {
        DFS(nums, 0, 0, 0);
        
        return answer;
    }
    
    public void DFS(int[] nums, int count, int sum, int index) {
        if (count == 3) {
            boolean ch = true;
            for (int i = 2; i <= Math.sqrt(sum); i++) {
                if (sum % i == 0) {
                    ch = false;
                    break;
                }
            }
            if (ch) answer++;
        } else {
            for (int i = index; i < nums.length; i++) {
                DFS(nums, count + 1, sum + nums[i], i + 1);
            }
        }
    }
}