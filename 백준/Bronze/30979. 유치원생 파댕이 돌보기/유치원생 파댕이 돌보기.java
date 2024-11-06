class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int t = read();
        int n = read();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += read();
        }
        String answer;
        if (t <= sum) answer = "Padaeng_i Happy";
        else answer = "Padaeng_i Cry";
        System.out.println(answer);
    }
}