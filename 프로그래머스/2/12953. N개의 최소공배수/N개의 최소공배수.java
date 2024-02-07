import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int num = max;
        
        while (true) {
            for (int i = 0; i < arr.length; i++) {
                if (num % arr[i] == 0) {
                    if (i == arr.length - 1) return num;
                } else break;
            }
            num += max;
        }
    }
}