class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        loop:
        while (true) {
            int c, v = 0;
            while ((c = System.in.read()) > 10) {
                if (c == '#') break loop;
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') v++;
                if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') v++;
            }
            sb.append(v).append("\n");
        }
        System.out.println(sb);
    }
}