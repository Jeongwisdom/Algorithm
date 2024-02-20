class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int id = 0;
        int maxId = 0;
        int max;
        int len = number.length() - k;
        while (sb.length() < len) {
            max = 0;
            for (int i = id; i <= id + k && i < number.length(); i++) {
                if (number.charAt(i) > max) {
                    max = number.charAt(i);
                    maxId = i;
                }
            }
            sb.append(max - '0');
            k -= (maxId - id);
            id = maxId + 1;
        }

        return sb.toString();
    }
}