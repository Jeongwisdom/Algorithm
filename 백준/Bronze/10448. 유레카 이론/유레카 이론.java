import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < t; i++) {
            if (check(arr[i], 0, 0)) bw.write("1");
            else bw.write("0");
            bw.write("\n");
        }
        bw.flush();
    }
    
    public static boolean check(int num, int count, int sum) {
        if (count == 3) {
            if (sum == num) return true;
        } else {
            int tri = 0;
            for (int i = 1; tri < num; i++) {
                tri += i;
                boolean ch = check(num, count + 1, sum + tri);
                if (ch) return true;
            }
        }
        
        return false;
    }
}