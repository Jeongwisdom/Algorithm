class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int a = read();
        int b = read();
        int minus = b - a;
        String answer;
        if (minus <= 0) answer = "Congratulations, you are within the speed limit!";
        else if (minus <= 20) answer = "You are speeding and your fine is $100.";
        else if (minus <= 30) answer = "You are speeding and your fine is $270.";
        else answer = "You are speeding and your fine is $500.";
        System.out.println(answer);
    }
}