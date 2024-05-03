import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        int n = read();
        int m = read();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int answer = 0;
        int f = 0;
        for (int i = 0; i < m; i++) {
            int num = read();
            int id = list.indexOf(num);
            int d = Math.abs(id - f);
            answer += Math.min(d, list.size() - d);
            list.remove(id);
            f = id;
        }
        System.out.println(answer);
    }
}