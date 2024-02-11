import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int[] arr = Arrays.stream(people).sorted().toArray();
        int answer = 0;
        
        int j = arr.length - 1;
        for (int i = 0; i < j; i++) {
            if (arr[i] + arr[j] <= limit) {
                answer++;
                arr[i] = Integer.MAX_VALUE;
                arr[j] = Integer.MAX_VALUE;
            } else i--;
            j--;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= limit) answer++;
        }
        
        return answer;
    }
}