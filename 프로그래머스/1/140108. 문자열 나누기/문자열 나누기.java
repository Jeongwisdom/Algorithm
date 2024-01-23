class Solution {
    public int solution(String s) {
        int answer = 0;
        char c = ' ';
        int x = 0;
        int y = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (x == 0) {
                c = s.charAt(i);
                x++;
            } else {
                if (s.charAt(i) == c) {
                    x++;
                } else {
                    y++;
                }
            }
            if (x == y) {
                answer++;
                x = 0;
                y = 0;
            } else if (i == s.length() - 1) answer++;
        }
        
        return answer;
    }
}