class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read() - 1;
        char[] labels = { 'W', 'e', 'l', 'c', 'o', 'm', 'e', 'T', 'o', 'S', 'M', 'U', 'P', 'C' };
        System.out.println(labels[n % 14]);
    }
}