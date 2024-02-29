class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] l = new int[10001];
        int[] r = new int[10001];
        int lNum = 0;
        int rNum = 0;
        for (int i: topping) {
            if (r[i] == 0) rNum += 1;
            r[i]++;
        }
        
        for (int i: topping) {
            if (l[i] == 0) lNum++;
            l[i]++;
            r[i]--;
            if (r[i] == 0) rNum--;
            if (lNum == rNum) answer++;
            if (lNum > rNum) break;
        }
        
        return answer;
    }
}