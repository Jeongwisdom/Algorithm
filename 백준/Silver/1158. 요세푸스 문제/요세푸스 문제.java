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
        int k = read();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int id = 0;
        while (!list.isEmpty()) {
            id = (id + k - 1) % list.size();
            sb.append(list.remove(id));
            if (!list.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}