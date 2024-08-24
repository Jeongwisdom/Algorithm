import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int digitCount = (int) Math.log10(n);
        int digits = (int) Math.pow(10, digitCount);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int num = 0;
            int number = n;
            int d = digits;
            int ex = 0;
            while (d > 0) {
                if (i == 0) {
                    if (n / d == ex * 10) {
                        if (ex > 0) num += (ex - 1) * d;
                        num += number % d + 1;
                    } else {
                        num += ex * d;
                    }
                } else {
                    if (number / d > i) num += d;
                    else if (number / d == i) num += number % d + 1;
                    num += ex * d;
                }
                ex = n / d;
                number %= d;
                d /= 10;
            }
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}