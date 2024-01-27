class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int time;
        
        for (int i = 0; i < attacks.length; i++) {
            time = attacks[i][0] - (i - 1 >= 0? attacks[i - 1][0] : 0);
            answer += (time - 1) * bandage[1] + ((time - 1) / bandage[0]) * bandage[2];
            if (answer > health) answer = health;
            answer -= attacks[i][1];
            if (answer <= 0) return -1;
        }
        
        return answer;
    }
}