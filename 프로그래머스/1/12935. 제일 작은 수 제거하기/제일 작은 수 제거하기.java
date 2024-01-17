import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[] {-1};
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
            list.add(arr[i]);
        }
        list.remove(index);
        return list.stream().mapToInt(i -> i).toArray();
    }
}