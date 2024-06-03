class Main {
    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        StringBuilder sb = new StringBuilder();
        String blank = " ";
        String star = "*";
        for (int i = 0; i < n; i++) {
            sb.append(blank.repeat(i)).append(star.repeat(n - i)).append("\n");
        }
        System.out.println(sb);
    }
}