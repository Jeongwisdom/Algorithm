class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        DFS(new int[m], 0);
        System.out.println(sb);
    }
    
    static void DFS(int[] arr, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                arr[count] = i;
                DFS(arr, count + 1);
            }
        }
    }
}