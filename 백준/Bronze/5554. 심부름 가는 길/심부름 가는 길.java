class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int sum = read() + read() + read() + read();
        StringBuilder sb = new StringBuilder();
        sb.append(sum / 60).append("\n").append(sum % 60);
        System.out.println(sb);
    }
}