import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int buffer = 1000000;
        boolean[] arr = new boolean[2 * buffer + 1];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine()) + buffer] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) sb.append(i - buffer).append("\n");
        }
        System.out.println(sb);
    }
}