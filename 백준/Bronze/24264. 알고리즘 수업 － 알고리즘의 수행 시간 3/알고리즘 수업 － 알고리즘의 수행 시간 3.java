class Main {
    public static void main(String[] args) throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        System.out.println(n * n + "\n" + (n == 0? 0: 2));
    }
}