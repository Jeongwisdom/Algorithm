import java.util.Arrays;

class Main {
    static int n, m;
    static int[] number, arr;
    static StringBuilder sb = new StringBuilder();
    
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = read();
        }
        arr = new int[m];
        Arrays.sort(number);
        DFS(0, 0);
        System.out.println(sb);
    }
    
    static void DFS(int id, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = id; i < n; i++) {
            arr[count] = number[i];
            DFS(i + 1, count + 1);
        }
    }
}