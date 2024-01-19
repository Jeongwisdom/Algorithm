class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] ar1 = new String[n];
        String[] ar2 = new String[n];
        String format = "%0" + n + "d";
        
        for (int i = 0; i < n; i++) {
            ar1[i] = String.format(format, Long.parseLong(Integer.toBinaryString(arr1[i])));
            ar2[i] = String.format(format, Long.parseLong(Integer.toBinaryString(arr2[i])));
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (ar1[i].charAt(j) == '0' && ar2[i].charAt(j) == '0') {
                    sb.append(" ");
                } else sb.append("#");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}