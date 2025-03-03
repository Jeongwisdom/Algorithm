import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] stack = new String[n];
        int size = 0;
        String str;
        while (n-- > 0) {
            str = br.readLine();
            switch (str.charAt(0)) {
                case 't':
                    if (size == 0) bw.write("-1");
                    else bw.write(stack[size - 1]);
                    bw.write("\n");
                    break;
                case 's':
                    bw.write(String.valueOf(size));
                    bw.write("\n");
                    break;
                case 'e':
                    if (size == 0) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case 'p':
                    if (str.charAt(1) == 'o') {
                        if (size == 0) bw.write("-1");
                        else {
                            size--;
                            bw.write(stack[size]);
                        }
                        bw.write("\n");
                    } else stack[size++] = str.substring(5);
            }
        }
        bw.flush();
    }
}