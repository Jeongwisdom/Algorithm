class Solution {
    public boolean solution(int x) {
        int y = x;
        int num = 0;
        while (y > 0) {
            num += y % 10;
            y /= 10;
        }
        return x % num == 0;
    }
}