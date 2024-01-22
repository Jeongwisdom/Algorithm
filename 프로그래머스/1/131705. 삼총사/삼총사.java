class Solution {
    
    int answer = 0;
    
    public int solution(int[] number) {
        DFS(0, 0, 0, number);
        
        return answer;
    }
    
    public void DFS(int count, int id, int sum, int[] number) {
        if (count == 3) {
            if (sum == 0) answer++;
        } else {
            for (int i = id; i < number.length; i++) {
                DFS(count + 1, i + 1, sum + number[i], number);
            }
        }
    }
}