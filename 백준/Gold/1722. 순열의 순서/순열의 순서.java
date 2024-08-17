import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean[] ch = new boolean[n + 1];
        String[] split = br.readLine().split(" ");
        int cmd = Integer.parseInt(split[0]);
        long fac = factorial(n - 1);
        int num = n - 1;
        if (cmd == 1) {
            long k = Long.parseLong(split[1]) - 1;
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
                int v = Integer.parseInt(split[i + 1]);
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