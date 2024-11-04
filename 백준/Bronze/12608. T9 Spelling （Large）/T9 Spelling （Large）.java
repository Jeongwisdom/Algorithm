import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = {2, 22, 222, 3, 33, 333, 4, 44, 444, 5, 55, 555, 6, 66, 666, 7, 77, 777, 7777, 8, 88, 888, 9, 99, 999, 9999};
        StringBuilder sb = new StringBuilder();
        int now, ex;
        for (int i = 1; i <= n; i++) {
            ex = 1;
            sb.append("Case #").append(i).append(": ");
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ' ') {
                    now = 0;
                } else {
                    now = arr[str.charAt(j) - 'a'];
                }
                if (ex % 10 == now % 10) sb.append(" ");
                sb.append(now);
                ex = now;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}