import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] q = new String[2000000];
        String str;
        int head = 0, tail = 0;
        while (n-- > 0) {
            str = br.readLine();
            switch (str.charAt(0)) {
                case 115:
                    bw.write(String.valueOf(tail - head));
                    bw.write("\n");
                    break;
                case 101:
                    if (head == tail) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case 102:
                    if (head == tail) bw.write("-1");
                    else bw.write(q[head]);
                    bw.write("\n");
                    break;
                case 98:
                    if (head == tail) bw.write("-1");
                    else bw.write(q[tail - 1]);
                    bw.write("\n");
                    break;
                default:
                    if (str.charAt(1) == 111) {
                        if (head == tail) bw.write("-1");
                        else {
                            bw.write(q[head++]);
                        }
                        bw.write("\n");
                    } else {
                        q[tail++] = str.substring(5);
                    }
            }
        }
        bw.flush();
    }
}