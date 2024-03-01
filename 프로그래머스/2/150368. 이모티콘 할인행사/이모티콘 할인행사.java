import java.util.*;

class Solution {
    int join = 0;
    int plus = 0;
    int max;
    int min;
    
    public int[] solution(int[][] users, int[] emoticons) {
        Arrays.sort(emoticons);
        Arrays.sort(users, (u1, u2) -> u2[0] - u1[0]);
        max = users[0][0] / 10 * 10 + (users[0][0] % 10 > 0? 10: 0);
        min = users[users.length - 1][0] / 10 * 10 + (users[users.length - 1][0] % 10 > 0? 10: 0);
        DFS(0, users, emoticons, new int[users.length], 0, 0);
        
        return new int[] {join, plus};
    }
    
    public void DFS(int count, int[][] users, int[] emoticons, int[] price, int total, int num) {
        if (count == emoticons.length) {
            if (join < num) {
                join = num;
                plus = total;
            } else if (join == num) plus = Math.max(plus, total);
        } else {
            for (int percent = max; percent >= min; percent -= 10) {
                int[] clone = price.clone();
                int j = 0;
                int sum = 0;
                for (int i = 0; i < users.length; i++) {
                    if (clone[i] >= 0 && users[i][0] <= percent) {
                        clone[i] += emoticons[count] * (100 - percent) / 100;
                        sum += emoticons[count] * (100 - percent) / 100;
                        if (clone[i] >= users[i][1]) {
                            sum -= clone[i];
                            clone[i] = -1;
                            j++;
                        }
                    }
                }
                DFS(count + 1, users, emoticons, clone, total + sum, num + j);
            }
        }
    }
}