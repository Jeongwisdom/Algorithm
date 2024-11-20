class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int s = read();
        int m = read();
        int l = read();
        int sum = s + 2 * m + 3 * l;
        String answer;
        if (sum < 10) answer = "sad";
        else answer = "happy";
        System.out.println(answer);
    }
}