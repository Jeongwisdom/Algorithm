import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int size = 0;
        String str;
        while (n-- > 0) {
            str = br.readLine();
            switch (str) {
                case "top":
                    if (size == 0) bw.write("-1");
                    else bw.write(String.valueOf(stack[size - 1]));
                    bw.write("\n");
                    break;
                case "size":
                    bw.write(String.valueOf(size));
                    bw.write("\n");
                    break;
                case "empty":
                    if (size == 0) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "pop":
                    if (size == 0) bw.write("-1");
                    else {
                        size--;
                        bw.write(String.valueOf(stack[size]));
                    }
                    bw.write("\n");
                    break;
                default:
                    stack[size++] = Integer.parseInt(str.substring(5));
            }
        }
        bw.flush();
    }
}