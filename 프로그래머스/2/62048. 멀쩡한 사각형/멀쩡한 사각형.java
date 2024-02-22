class Solution {
    public long solution(int w, int h) {
        long gcd = getGcd(w, h);
        return (long) w * h - (w + h - gcd);
    }
    
    private long getGcd(long a, long b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
}