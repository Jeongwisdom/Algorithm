class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long num = Long.parseLong(p);

        long n = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            for (int j = i; j < i + p.length(); j++) {
                n = n * 10 + t.charAt(j) - '0';
            }
            if (n <= num) answer++;
            n = 0;
        }

        return answer;
    }
}