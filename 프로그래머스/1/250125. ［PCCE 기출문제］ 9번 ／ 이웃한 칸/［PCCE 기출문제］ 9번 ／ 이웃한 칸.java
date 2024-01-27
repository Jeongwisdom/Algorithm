class Solution {
    public int solution(String[][] board, int h, int w) {
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        int answer = 0;
        int dh, dw;
        
        for (int i = 0; i < dx.length; i++) {
            dh = h + dx[i];
            dw = w + dy[i];
            if (dh >= 0 && dw >= 0 && dh < board.length && dw < board.length && board[h][w].equals(board[dh][dw])) answer++;
        }
        
        return answer;
    }
}