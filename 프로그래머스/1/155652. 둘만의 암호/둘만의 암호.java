class Solution {
    public String solution(String s, String skip, int index) {
        char[] chars = new char[26 - skip.length()];
        int i = 0;
        boolean ch;
        for (char c = 97; c <= 122; c++) {
            ch = true;
            for (char a: skip.toCharArray()) {
                if (c == a) {
                    ch = false;
                    break;
                }
            }
            if (ch) {
                chars[i] = c;
                i++;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int j = 0; j < s.length(); j++) {
            for (int k = 0; k < chars.length; k++) {
                if (chars[k] == s.charAt(j)) {
                    answer.append(chars[k + index >= chars.length? (k + index) % chars.length: k + index]);
                    break;
                }
            }
        }

        return answer.toString();
    }
}