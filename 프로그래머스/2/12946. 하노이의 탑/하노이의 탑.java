class Solution {
    
    int[][] answer;
    int idx;
    
    public int[][] solution(int n) {
        answer = new int[(int) Math.pow(2, n) - 1][2];
        idx = 0;
        
        hanoi(n, 1, 2, 3);
        
        return answer;
    }
    
    public void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            answer[idx][0] = start;
            answer[idx++][1] = to;
            return;
        }
        
        hanoi(n - 1, start, to, mid);
        
        answer[idx][0] = start;
        answer[idx++][1] = to;
        
        hanoi(n - 1, mid, start, to);
    }
}