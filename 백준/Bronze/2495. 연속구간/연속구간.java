class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int answer, max, num, ex;
        for (int i = 0; i < 3; i++) {
            answer = 1;
            max = 1;
            ex = -1;
            for (int j = 0; j < 8; j++) {
                num = System.in.read() & 15;
                if (num == ex) max++;
                else max = 1;
                if (answer < max) answer = max;
                ex = num;
            }
            sb.append(answer).append("\n");
            System.in.read();
        }
        System.out.println(sb);
    }
}