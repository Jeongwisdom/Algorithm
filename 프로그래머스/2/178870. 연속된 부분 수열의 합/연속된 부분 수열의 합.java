class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int length = 1000001;
        int sum = 0;
        int i = 0;
        while (start < sequence.length) {
            if (sum == k) {
                if (i - start < length) {
                    length = i - start;
                    answer[0] = start;
                    answer[1] = i - 1;
                }
            }
            if (sum <= k && i < sequence.length) sum += sequence[i++];
            else sum -= sequence[start++];
        }
        
        return answer;
    }
}