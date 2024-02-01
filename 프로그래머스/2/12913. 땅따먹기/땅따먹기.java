class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length + 1][4];
        int max;

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k && max < land[i][j] + dp[i][k]) {
                        max = land[i][j] + dp[i][k];
                    }
                }
                dp[i + 1][j] = max;
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[dp.length - 1][i]);
        }
        return answer;
    }
}