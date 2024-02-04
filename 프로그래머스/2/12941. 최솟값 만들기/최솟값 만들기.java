import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Integer[] arr = new Integer[B.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = B[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * arr[i];
        }

        return answer;
    }
}