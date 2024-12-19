class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int num, sum = 0;
        for (int i = 0; i < 5; i++) {
            num = read();
            if (num <= 40) sum += 40;
            else sum += num;
        }
        System.out.println(sum / 5);
    }
}