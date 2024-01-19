import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        
        for (int i: lost) {
            set.remove(i);
        }
        
        Arrays.sort(reserve);
        for (int i = 0; i < reserve.length; i++) {
            int num = reserve[i];
            if (!set.contains(num)) set.add(num);
            else if (num != 1 && !set.contains(num - 1)) set.add(num - 1);
            else if (num != n && !set.contains(num + 1) && (i == reserve.length - 1 || reserve[i + 1] != num + 1)) set.add(num + 1);
        }
        
        return set.size();
    }
}