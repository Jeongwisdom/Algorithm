class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] ar1 = new String[n];
        String[] ar2 = new String[n];
        String format = "%" + n + "s";
        
        StringBuilder sb;
        for (int i = 0; i < n; i++) {
            ar1[i] = String.format(format, Integer.toBinaryString(arr1[i]));
            ar2[i] = String.format(format, Integer.toBinaryString(arr2[i]));
            sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if ((ar1[i].charAt(j) == '0' || ar1[i].charAt(j) == ' ') && (ar2[i].charAt(j) == '0' || ar2[i].charAt(j) == ' ')) {
                    sb.append(" ");
                } else sb.append("#");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}