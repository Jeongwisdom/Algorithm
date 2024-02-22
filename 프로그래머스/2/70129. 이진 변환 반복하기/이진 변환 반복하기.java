class Solution {
    public int[] solution(String s) {
        int len;
        int count = 0;
        int remove = 0;
        while (!s.equals("1")) {
            len = 0;
            for (char c: s.toCharArray()) {
                if (c == '1') len++;
                else remove++;
            }
            s = Integer.toString(len, 2);
            count++;
        }
        
        return new int[] {count, remove};
    }
}