class Main {
    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }

    public static void main(String[] args) throws Exception {
        int num;
        StringBuilder sb = new StringBuilder();
        while ((num = read()) != 0) {
            for (int i = 1; i <= num; i++) {
                sb.append("*".repeat(i)).append("\n");
            }
        }
        System.out.println(sb);
    }
}