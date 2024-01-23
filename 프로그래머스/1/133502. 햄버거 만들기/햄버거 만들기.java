class Solution {
    public int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        
        for (int i: ingredient) {
            sb.append(i);
            if (sb.length() >= 4 && sb.charAt(sb.length() - 4) == '1' && sb.charAt(sb.length() - 3) == '2' && sb.charAt(sb.length() - 2) == '3' && sb.charAt(sb.length() - 1) == '1') {
                sb.setLength(sb.length() - 4);
                answer++;
            }
        }

        return answer;
    }
}