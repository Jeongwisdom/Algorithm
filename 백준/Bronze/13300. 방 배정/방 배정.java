class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int k = read();
        int[][] student = new int[2][7];
        for (int i = 0; i < n; i++) {
            student[read()][read()]++;
        }
        
        int answer = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                int v = student[i][j] / k + 1;
                if (student[i][j] % k == 0) v--;
                answer += v;
            }
        }
        System.out.println(answer);
    }
}