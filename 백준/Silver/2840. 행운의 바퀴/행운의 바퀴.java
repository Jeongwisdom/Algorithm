class Main {
    static int read(boolean ch) throws Exception {
        int c, n;
        if (!ch) n = System.in.read() & 15;
        else n = System.in.read();
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read(false);
        int k = read(false);
        char[] arr = new char[n];
        int[] ch = new int[26];
        for (int i = 0; i < n; i++) {
            arr[i] = '?';
        }
        for (int i = 0; i < 26; i++) {
            ch[i] = -1;
        }
        int id = 0;
        for (int i = 0; i < k; i++) {
            int num = read(false);
            char c = (char) read(true);
            id = (id + num) % n;
            if ((arr[id] != '?' && arr[id] != c) || (ch[c - 'A'] != -1 && ch[c - 'A'] != id)) {
                id = -1;
                break;
            }
            arr[id] = c;
            ch[c - 'A'] = id;
        }
        StringBuilder sb = new StringBuilder();
        if (id == -1) sb.append("!");
        else {
            int count = 0;
            while (count++ < n) {
                sb.append(arr[id]);
                id--;
                if (id < 0) id = n - 1;
            }
        }
        System.out.println(sb);
    }
}