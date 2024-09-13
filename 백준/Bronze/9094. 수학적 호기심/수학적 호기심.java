class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int t = read();
        for (int i = 0; i < t; i++) {
            int n = read();
            int m = read();
            int answer = 0;
            for (int j = 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((j * j + k * k + m) % (j * k) == 0) answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}