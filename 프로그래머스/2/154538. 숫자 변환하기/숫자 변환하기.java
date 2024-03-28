import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] ch = new boolean[y];
        q.offer(y);
        int count = 0;
        while (!q.isEmpty()) {
            Queue<Integer> tmp = new ArrayDeque<>();
            while (!q.isEmpty()) {
                int num = q.poll();
                if (x == num) return count;
                if (num % 3 == 0 && num / 3 >= x && !ch[num / 3]) {
                    ch[num / 3] = true;
                    tmp.offer(num / 3);
                }
                if (num % 2 == 0 && num / 2 >= x && !ch[num / 2]) {
                    ch[num / 2] = true;
                    tmp.offer(num / 2);
                }
                if (num - n >= x && !ch[num - n]) {
                    ch[num - n] = true;
                    tmp.offer(num - n);
                }
            }
            q = tmp;
            count++;
        }
        
        return -1;
    }
}