class Main {
    public static void main(String[] args) throws Exception {
        int r, n = System.in.read() & 15;
        while ((r = System.in.read()) > 47) n = (n << 3) + (n << 1) + (r & 15);
        String bi = Integer.toBinaryString(n);
        int answer = 0;
        for (char c: bi.toCharArray()) {
            if (c == '1') answer++;
        }
        System.out.println(answer);
    }
}