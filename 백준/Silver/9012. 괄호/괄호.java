class Main {
    static void read() throws Exception {
        int c;
        while ((c = System.in.read()) > 31) {} 
    }
    
    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);

        StringBuilder sb = new StringBuilder();
        int tail;
        while (n-- > 0) {
            tail = 0;
            while ((c = System.in.read()) > 31) {
                if (c == '(') {
                    tail++;
                } else {
                    if (tail == 0) {
                        tail++;
                        read();
                        break;
                    } else {
                        tail--;
                    }
                }
            }
            if (tail == 0) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}