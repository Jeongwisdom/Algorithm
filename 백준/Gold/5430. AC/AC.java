import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int c = 0; c < n; c++) {
            String command = br.readLine();
            int m = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replaceAll("[\\[\\]]", "").split(",");
            int h = 0;
            int t = m - 1;
            boolean zero = m == 0;
            boolean ch = true;
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'R') {
                    int tmp = h;
                    h = t;
                    t = tmp;
                } else {
                    if (zero) {
                        ch = false;
                        break;
                    } else if (h < t) h++;
                    else if (h > t) h--;
                    else zero = true;
                }
            }
            if (!ch) sb.append("error\n");
            else {
                sb.append("[");
                if (!zero) {
                    if (h <= t) {
                        for (int i = h; i <= t; i++) {
                            sb.append(arr[i]);
                            if (i < t) sb.append(",");
                        }
                    } else {
                        for (int i = h; i >= t; i--) {
                            sb.append(arr[i]);
                            if (i > t) sb.append(",");
                        }
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}