import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int p = read();
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            map.put(i, new Stack<>());
        }
        Stack<Integer> s;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int line = read();
            int num = read();
            s = map.get(line);
            while (!s.isEmpty() && s.peek() > num) {
                s.pop();
                answer++;
            }
            if (s.isEmpty() || s.peek() < num) {
                s.push(num);
                answer++;
            }
        }
        System.out.println(answer);
    }
}