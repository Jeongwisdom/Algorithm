import java.util.Arrays;

class Main {
    static int n, m;
    static int[] number, arr;
    static StringBuilder sb = new StringBuilder();
    
    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }
    
    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        
        number = new int[n];
        arr = new int[m];
        for (int i = 0; i < n; i++) number[i] = read();
        
        Arrays.sort(number);
        DFS(0, 0);
        System.out.println(sb);
    }
    
    static void DFS(int id, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) sb.append(arr[i]).append(' ');
            sb.append("\n");
            return;
        }
        int store = 0;
        for (int i = id; i < n; i++) {
            if (store == number[i]) continue;
            store = number[i];
            arr[count] = number[i];
            DFS(i + 1, count + 1);
        }
    }
}