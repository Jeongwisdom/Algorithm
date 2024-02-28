import java.util.*;

class Solution {
    Set<long[]> set = new HashSet<>();;
    long minX = Long.MAX_VALUE;
    long maxX = Long.MIN_VALUE;
    long minY = Long.MAX_VALUE;
    long maxY = Long.MIN_VALUE;
    
    public String[] solution(int[][] line) {
        DFS(line, 0, 0, new int[2][3]);
        
        String[] answer = new String[(int) (maxY - minY + 1)];
        String s = ".";
        s = s.repeat((int) (maxX - minX + 1));
        for (int i = 0; i < answer.length; i++) {
            answer[i] = s;
        }
        for (long[] arr: set) {
            StringBuilder sb = new StringBuilder(answer[(int) (maxY - arr[1])]);
            sb.setCharAt((int) (arr[0] - minX), '*');
            answer[(int) (maxY - arr[1])] = sb.toString();
        }
        
        return answer;
    }
    
    public void DFS(int[][] line, int count, int id, int[][] arr) {
        if (count == 2) {
            long[] point = calculate(arr);
            if (point != null) set.add(point);
        } else {
            for (int i = id; i < line.length; i++) {
                arr[count] = line[i];
                DFS(line, count + 1, i + 1, arr);
            }
        }
    }
    
    public long[] calculate(int[][] arr) {
        double b = 1.0 * arr[0][0] * arr[1][1] - 1.0 * arr[1][0] * arr[0][1];
        if (b == 0) return null;
        double x = (1.0 * arr[0][1] * arr[1][2] - 1.0 * arr[1][1] * arr[0][2]) / b;
        double y = (1.0 * arr[0][2] * arr[1][0] - 1.0 * arr[0][0] * arr[1][2]) / b;
        if (x % 1 != 0.0) return null;
        if (y % 1 != 0.0) return null;
        minX = Math.min(minX, (long) x);
        maxX = Math.max(maxX, (long) x);
        minY = Math.min(minY, (long) y);
        maxY = Math.max(maxY, (long) y);
        return new long[] {(long) x, (long) y};
    }
}