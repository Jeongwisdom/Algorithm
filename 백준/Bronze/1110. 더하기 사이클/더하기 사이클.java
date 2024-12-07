class Main {
    public static void main(String[] args) throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        int answer = 0;
        int ex = c;
        int one;
        while (true) {
            one = ex % 10;
            ex /= 10;
            ex = (one * 10) + (one + ex) % 10;
            answer++;
            if (ex == c) break;
        }
        System.out.println(answer);
    }
}