class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int count = -1;
        int x = (int) (left / n);
        int y = (int) (left % n);
        while (count++ < answer.length - 1) {
            answer[count] = Math.max(x, y) + 1;
            if (y == n - 1) {
                x++;
                y = 0;
            } else y++;
        }
        
        return answer;
    }
}