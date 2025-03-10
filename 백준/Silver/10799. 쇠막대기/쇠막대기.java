class Main {
    public static void main(String[] args) throws Exception {
        int c, ex = 0, tail = 0, answer = 0;
        while ((c = System.in.read()) > 31) {
            if (c == '(') tail++;
            else {
                tail--;
                if (ex == '(') {
                    answer += tail;
                } else answer++;
            }
            ex = c;
        }
        System.out.println(answer);
    }
}