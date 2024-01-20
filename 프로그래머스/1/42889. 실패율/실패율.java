import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N + 1];
        for (int i = 0; i < stages.length; i++) {
            arr[stages[i] - 1]++;
        }
        
        Map<Integer, Float> rates = new HashMap<>();
        float sum = stages.length;
        for (int i = 0; i < arr.length - 1; i++) {
            rates.put(i + 1, sum == 0? 0: arr[i] / sum);
            sum -= arr[i];
        }
        
        return rates.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .mapToInt(Map.Entry::getKey)
            .toArray();
    }
}