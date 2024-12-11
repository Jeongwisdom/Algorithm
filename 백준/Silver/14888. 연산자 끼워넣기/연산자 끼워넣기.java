class Main {
    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr, op;
    
    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }
    
    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n];
        op = new int[4];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        for (int i = 0; i < 4; i++) {
            op[i] = read();
        }
        
        DFS(1, arr[0]);
        
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }
    
    static void DFS(int id, int num) {
        if (id == n) {
            if (max < num) max = num;
            if (min > num) min = num;
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                int cal = calculate(i, num, arr[id]);
                op[i]--;
                DFS(id + 1, cal);
                op[i]++;
            }
        }
    }
    
    static int calculate(int i, int a, int b) {
        if (i == 0) return a + b;
        if (i == 1) return a - b;
        if (i == 2) return a * b;
        return a / b;
    }
}