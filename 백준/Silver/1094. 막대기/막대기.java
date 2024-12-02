class Main {
    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        String bi = Integer.toBinaryString(n);
        int answer = 0;
        for (int i = 0; i < bi.length(); i++) {
            if (bi.charAt(i) == '1') answer++;
        }
        System.out.println(answer);
    }
}