class Main {
    static int[] union;
    
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int n, m, t = 1;
        while (true) {
            n = read();
            m = read();
            if (n == 0) break;
            
            union = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                union[i] = i;
            }
            
            int a, b;
            for (int i = 0; i < m; i++) {
                a = read();
                b = read();
                union(a, b);
            }
            
            boolean[] ch = new boolean[n + 1];
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                int root = find(i);
                if (root > 0 && !ch[root]) {
                    ch[root] = true;
                    answer++;
                }
            }
            
            if (answer == 0) sb.append("Case ").append(t).append(": No trees.\n");
            else if (answer == 1) sb.append("Case ").append(t).append(": There is one tree.\n");
            else sb.append("Case ").append(t).append(": A forest of ").append(answer).append(" trees.\n");
            t++;
        }
        System.out.println(sb);
    }
    
    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        
        if (fa < fb) union[fb] = fa;
        else if (fb < fa) union[fa] = fb;
        else union[fa] = 0;
    }
    
    static int find(int i) {
        if (union[i] == 0) return 0;
        if (union[i] == i) return i;
        return union[i] = find(union[i]);
    }
}