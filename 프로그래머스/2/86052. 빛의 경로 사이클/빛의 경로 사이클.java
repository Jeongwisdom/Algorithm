import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        List<Integer> list = new ArrayList<>();
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int col = grid.length;
        int row = grid[0].length();
        boolean[][][] ch = new boolean[4][col][row];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < row; k++) {
                    int count = 0, id = i, x = j, y = k;
                    while (!ch[id][x][y]) {
                        ch[id][x][y] = true;
                        if (grid[x].charAt(y) == 'L') {
                            id = id - 1 < 0? 3: id - 1;
                        } else if (grid[x].charAt(y) == 'R') {
                            id = id + 1 >= 4? 0: id + 1;
                        }
                        x = (x + dx[id] < 0? grid.length + x + dx[id]: x + dx[id]) % col;
                        y = (y + dy[id] < 0? grid[0].length() + y + dy[id]: y + dy[id]) % row;
                        count++;
                    }
                    if (count != 0) list.add(count);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
}