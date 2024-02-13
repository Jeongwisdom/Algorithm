class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int l = (t - 1) * m + p;
        int num = 0;
        while (sb.length() <= l) {
            sb.append(Integer.toString(num++, n).toUpperCase());
        }
        
        StringBuilder answer = new StringBuilder();
        for (int i = p - 1; i <= l; i += m) {
            answer.append(sb.charAt(i));
        }
        return answer.toString();
    }
}