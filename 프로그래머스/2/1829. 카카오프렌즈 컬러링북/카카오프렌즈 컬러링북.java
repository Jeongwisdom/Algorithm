import java.util.Stack;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] ch = new boolean[m][n];
        int[] dx = {-1, 1, 0, 0};
       int[] dy = {0, 0, -1, 1};
       int numberOfArea = 0;
       int maxSizeOfOneArea = 0;
       Stack<Integer[]> stack = new Stack<>();
       Integer[] point;
       int color, x, y, size;

       for (int i = 0; i < picture.length; i++) {
           for (int j = 0; j < picture[i].length; j++) {
               if (!ch[i][j] && picture[i][j] != 0) {
                   size = 0;
                   stack.push(new Integer[] {i, j});
                   ch[i][j] = true;
                   while (!stack.isEmpty()) {
                       point = stack.pop();
                       color = picture[point[0]][point[1]];
                       size++;
                       for (int k = 0; k < dx.length; k++) {
                           x = point[0] + dx[k];
                           y = point[1] + dy[k];
                           if (x >= 0 && y >= 0 && x < picture.length && y < picture[x].length && !ch[x][y] && picture[x][y] == color) {
                               ch[x][y] = true;
                               stack.push(new Integer[] {x, y});
                           }
                       }
                   }
                   numberOfArea++;
                   maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
               } else if (picture[i][j] == 0) ch[i][j] = true;
           }
       }

       return new int[] {numberOfArea, maxSizeOfOneArea};
    }
}

class Point {
    
    int x;
    int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}