class Main {
    static int c, n;
    
    static int read() throws Exception {
        n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] buildings = new int[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = read();
        }
        
        long answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (buildings[i] <= buildings[j]) break;
                answer++;
            }
        }
        System.out.println(answer);
    }
}