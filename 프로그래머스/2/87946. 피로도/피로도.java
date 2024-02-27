class Solution {
    int answer;
    int min;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < dungeons.length; i++) {
            min = Math.min(min, dungeons[i][0]);
        }
        DFS(dungeons, new boolean[dungeons.length], k, 0);
        return answer;
    }
    
    public void DFS(int[][] dungeons, boolean[] ch, int k, int count) {
        if (k < min || count == ch.length) {
            answer = Math.max(answer, count);
        } else {
            for (int i = 0; i < ch.length; i++) {
                if (!ch[i] && k >= dungeons[i][0]) {
                    ch[i] = true;
                    DFS(dungeons, ch, k - dungeons[i][1], count + 1);
                    ch[i] = false;
                }
            }
        }
    }
}