class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (char c: s.toCharArray()) {
            char x = (char) (c + n);
            if (c >= 'a' && c <= 'z') {
                if (x > 'z') x -= 26;
                answer.append(x);
            } else if (c >= 'A' && c <= 'Z') {
                if (x > 'Z') x -= 26;
                answer.append(x);
            } else answer.append(c);
        }
        return answer.toString();
    }
}