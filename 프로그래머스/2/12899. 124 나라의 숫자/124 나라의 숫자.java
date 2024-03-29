class Solution {
    public String solution(int n) {
        int[] arr = {4, 1, 2};
        StringBuilder answer = new StringBuilder();
        
        while (n != 0) {
            answer.append(arr[n % 3]);
            n = (n - 1) / 3;
        }
        
        return answer.reverse().toString();
    }
}