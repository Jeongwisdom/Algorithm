import java.util.Stack;

class Solution {
    
    boolean[][] ch;
    int numberOfArea;
    int maxSizeOfOneArea;
    int size;
    Stack<Point> stack;
    
    public int[] solution(int m, int n, int[][] picture) {
        ch = new boolean[m][n];
        stack = new Stack<>();
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!ch[i][j] && picture[i][j] != 0) {
                    ch[i][j] = true;
                    stack.push(new Point(i, j));
                    size = 1;
                    DFS(picture);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                } else if (picture[i][j] == 0) {
                    ch[i][j] = true;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public void DFS(int[][] picture) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Point point;
        
        point = stack.pop();
        for (int i = 0; i < dx.length; i++) {
            if (point.x + dx[i] >= 0 && point.y + dy[i] >= 0 && point.x + dx[i] < picture.length && point.y + dy[i] < picture[0].length && picture[point.x + dx[i]][point.y + dy[i]] == picture[point.x][point.y] && !ch[point.x + dx[i]][point.y + dy[i]]) {
                ch[point.x + dx[i]][point.y + dy[i]] = true;
                stack.push(new Point(point.x + dx[i], point.y + dy[i]));
                size++;
                DFS(picture);
            }
        }
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