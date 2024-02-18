class Solution {
    
    int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        DFS(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void DFS(int[] numbers, int target, int id, int sum) {
        if (id == numbers.length) {
            if (sum == target) answer++;
        } else {
            DFS(numbers, target, id + 1, sum + numbers[id]);
            DFS(numbers, target, id + 1, sum - numbers[id]);
        }
    }
}