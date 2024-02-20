class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length() - k;
        for (int i = 0; i < number.length(); i++) {
            while (answer.length() > 0 && answer.charAt(answer.length() - 1) < number.charAt(i) && k > 0) {
                answer.deleteCharAt(answer.length() - 1);
                k--;
            }
            if (answer.length() < len) answer.append(number.charAt(i));
        }
        
        return answer.toString();
    }
}