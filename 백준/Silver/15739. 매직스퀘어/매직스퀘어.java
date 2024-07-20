class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int sum = n * (n * n + 1) / 2;
        int[][] arr = new int[n][n];
        boolean answer = true;
        boolean[] ch = new boolean[n * n + 1];
        loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = read();
                if (ch[arr[i][j]]) {
                    answer = false;
                    break loop;
                }
                else ch[arr[i][j]] = true;
            }
        }
        
        if (answer) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < n; i++) {
                a += arr[i][i];
                b += arr[n - 1 - i][n - 1 - i];
            }
            if (a != sum || b != sum) answer = false;
        }
        if (answer) {
            for (int i = 0; i < n; i++) {
                int row = 0;
                int column = 0;
                for (int j = 0; j < n; j++) {
                    row += arr[i][j];
                    column += arr[j][i];
                }
                if (row != sum || column != sum) {
                    answer = false;
                    break;
                }
            }
        }
        System.out.println(answer? "TRUE": "FALSE");
    }
}