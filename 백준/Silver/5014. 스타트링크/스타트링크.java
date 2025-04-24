class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int F = read(), S = read(), G = read(), U = read(), D = read(), cnt = 0;
        int[] ch = new int[F + 1];
        while (S != G) {
            ch[S] = 1;
            if (S < G) {
                if (S + U <= F && ch[S + U] == 0) S += U;
                else if (S - D > 0 && ch[S - D] == 0) S -= D;
                else {
                    System.out.println("use the stairs");
                    return;
                }
            } else {
                if (S - D > 0 && ch[S - D] == 0) S -= D;
                else if (S + U <= F && ch[S + U] == 0) S += U;
                else {
                    System.out.println("use the stairs");
                    return;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}