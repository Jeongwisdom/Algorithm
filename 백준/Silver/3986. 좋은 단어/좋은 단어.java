class Main {
    public static void main(String[] args) throws Exception {
        int a, n = System.in.read() & 15;
        while ((a = System.in.read()) > 32) n = (n << 3) + (n << 1) + (a & 15);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            char c;
            char[] s = new char[100000];
            int id = -1;
            while ((c = (char) System.in.read()) > 32) {
                if (id == -1 || s[id] != c) {
                    s[++id] = c;
                } else id--;
            }
            if (id == -1) answer++;
        }
        System.out.println(answer);
    }
}