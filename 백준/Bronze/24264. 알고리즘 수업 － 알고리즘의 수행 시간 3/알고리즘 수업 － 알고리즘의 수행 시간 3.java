class Main {
    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        long sum = (long) n * n;
        System.out.println(sum);
        System.out.println(2);
    }
}