import java.io.*;

class Main {
    static long read() throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        long n = read();
        boolean[] ch = new boolean[(int) n + 1];
        long cmd = read();
        long fac = factorial((int) n - 1);
        long num = n - 1;
        if (cmd == 1) {
            long k = read() - 1;
            while (k > 0) {
                long order = k / fac;
                for (int i = 1; i <= n; i++) {
                    if (!ch[i]) {
                        if (order == 0) {
                            ch[i] = true;
                            sb.append(i).append(" ");
                            break;
                        }
                        order--;
                    }
                }
                k %= fac;
                fac /= num;
                num--;
            }
            for (int i = 1; i <= n; i++) {
                if (!ch[i]) {
                    sb.append(i).append(" ");
                }
            }
        } else {
            long answer = 1;
            for (int i = 0; i < n - 1; i++) {
                long v = read();
                int figure = 0;
                for (int j = 1; j <= n; j++) {
                    if (j == v) {
                        ch[j] = true;
                        answer += figure * fac;
                        break;
                    }
                    if (!ch[j]) figure++;
                }
                fac /= num;
                num--;
            }
            sb.append(answer);
        }
        System.out.println(sb);
    }

    static long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}