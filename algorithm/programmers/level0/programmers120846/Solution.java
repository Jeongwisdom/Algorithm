package programmers.level0.programmers120846;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int num = 0;
            for (int j = 1; j <= i; j++) {
                if(i % j == 0) num++;
            }
            if(num >= 3) answer++;
        }
        return answer;
    }
}
