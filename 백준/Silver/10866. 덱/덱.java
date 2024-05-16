import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[2 * n + 1];
        int h = n;
        int t = n;
        String[] split;
        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            switch (split[0]) {
                case "push_front":
                    arr[h--] = Integer.parseInt(split[1]);
                    break;
                case "push_back":
                    arr[++t] = Integer.parseInt(split[1]);
                    break;
                case "pop_front":
                    if (h == t) sb.append("-1\n");
                    else sb.append(arr[++h]).append("\n");
                    break;
                case "pop_back":
                    if (h == t) sb.append("-1\n");
                    else sb.append(arr[t--]).append("\n");
                    break;
                case "size":
                    sb.append(t - h).append("\n");
                    break;
                case "empty":
                    if (t - h == 0) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front":
                    if (h == t) sb.append("-1\n");
                    else sb.append(arr[h + 1]).append("\n");
                    break;
                default:
                    if (h == t) sb.append("-1\n");
                    else sb.append(arr[t]).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}