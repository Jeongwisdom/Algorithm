class Main {
    static long read() throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        long x = read();
        long y = read();
        long w = read();
        long s = read();
        long min = x < y? x: y;
        long max = x < y? y: x;
        long answer;
        if (2 * w > s) {
            answer = min * s;
            if (w > s) answer += (max - min) / 2 * 2 * s + (max - min) % 2 * w;
            else answer += (max - min) * w;
        } else answer = w * (x + y);
        System.out.println(answer);
    }
}