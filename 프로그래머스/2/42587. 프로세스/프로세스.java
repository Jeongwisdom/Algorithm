import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new ArrayDeque<>();
        Integer[] max = new Integer[priorities.length];
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] {i, priorities[i]});
            max[i] = priorities[i];
        }
        Arrays.sort(max, Collections.reverseOrder());
        
        int i = 0;
        int[] tmp;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (tmp[1] == max[i]) {
                i++;
                if (location == tmp[0]) return i;
            } else queue.offer(tmp);
        }
        
        return 0;
    }
}