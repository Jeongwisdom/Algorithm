class Main {
    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}