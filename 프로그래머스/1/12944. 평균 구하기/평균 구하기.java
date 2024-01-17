import java.util.*;

class Solution {
    public double solution(int[] arr) {
        return Arrays.stream(arr).sum() / (arr.length + 0.0);
    }
}