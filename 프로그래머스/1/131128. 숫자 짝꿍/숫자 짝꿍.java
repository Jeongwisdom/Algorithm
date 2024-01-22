class Solution {
    public String solution(String X, String Y) {
        int[] x = new int[10];
        int[] y = new int[10];
        int[] arr = new int[10];
        int num, len;
        
        for (int i = 0; i < X.length(); i++) {
            num = X.charAt(i) - '0';
            x[num]++;
        }
        for (int i = 0; i < Y.length(); i++) {
            num = Y.charAt(i) - '0';
            y[num]++;
        }
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.min(x[i], y[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            len = arr[i];
            if (i == 0 && sb.length() == 0 && len > 0) {
                len = 1;
            }
            for (int j = 0; j < len; j++) {
                sb.append(i);
            }
        }
        
        return sb.length() == 0? "-1": sb.toString();
    }
}