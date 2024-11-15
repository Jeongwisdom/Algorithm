class Main {
    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        String answer = "Goose";
        if (n % 2 == 0) answer = "Duck";
        System.out.println(answer);
    }
}