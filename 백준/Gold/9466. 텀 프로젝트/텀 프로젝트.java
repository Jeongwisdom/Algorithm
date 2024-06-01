class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int t = read();
        for (int c = 0; c < t; c++) {
            int n = read();
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = read();
            }
            boolean[] ch = new boolean[n + 1];
            boolean[] visited = new boolean[n + 1];
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                if (!ch[i]) answer += DFS(arr, ch, visited, i);
            }
            sb.append(n - answer).append("\n");
        }
        System.out.println(sb);
    }
    
    static int DFS(int[] arr, boolean[] ch, boolean[] visited, int id) {
        int count = 0;
        if (!ch[id]) {
            ch[id] = true;
            count += DFS(arr, ch, visited, arr[id]);
            visited[id] = true;
        } else {
            while (!visited[id]) {
                visited[id] = true;
                count++;
                id = arr[id];
            }
        }
        return count;
    }
}