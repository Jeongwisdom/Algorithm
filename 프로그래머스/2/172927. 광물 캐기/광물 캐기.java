class Solution {
    int answer = 10000;
    
    public int solution(int[] picks, String[] minerals) {
        DFS(picks, minerals, 0, 0);
        return answer;
    }
    
    void DFS(int[] picks, String[] minerals, int l, int a) {
        if (l >= minerals.length || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)) {
            if (answer > a) answer = a;
        } else {
            for (int i = 2; i >= 0; i--) {
                if (picks[i] > 0) {
                    picks[i]--;
                    int sum = 0;
                    for (int j = l; j < l + 5; j++) {
                        if (j == minerals.length) break;
                        int mineral = 0;
                        if (minerals[j].equals("iron")) mineral = 1;
                        else if (minerals[j].equals("stone")) mineral = 2;
                        int c = (int) Math.pow(5, i - mineral <= 0? 0: i - mineral);
                        sum += c;
                    }
                    DFS(picks, minerals, l + 5, a + sum);
                    picks[i]++;
                }
            }
        }
    }
}