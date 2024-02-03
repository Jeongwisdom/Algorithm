class Solution {
    public int solution(int[][] board) {
        int[][] dp = new int[board.length][board[0].length];
        int answer = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        
        return answer * answer;
    }
}