class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        boolean ch = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(" ");
                ch =true;
            } else {
                if (ch) sb.append(Character.toUpperCase(s.charAt(i)));
                else sb.append(Character.toLowerCase(s.charAt(i)));
                ch = false;
            }
        }
        
        return sb.toString();
    }
}