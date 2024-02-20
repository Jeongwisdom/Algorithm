import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i <= citations.length / 2; i++) {
            if (citations[i] >= citations.length - i) return citations.length - i;
        }
        return 0;
    }
}