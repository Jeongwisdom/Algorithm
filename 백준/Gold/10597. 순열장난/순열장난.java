import java.io.*;

class Main {
    static boolean flag = false;
    static String str;
    static StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        DFS(new int[51], new boolean[51], 0, 0);
        System.out.println(answer);
    }
    
    static void DFS(int[] arr, boolean[] ch, int id, int count) {
        if (flag) return;
        if (id == str.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                if (arr[i] > count) return;
                sb.append(arr[i]).append(" ");
            }
            answer = sb;
            flag = true;
        } else {
            int num1 = str.charAt(id) - '0';
            if (num1 < 51 && !ch[num1]) {
                ch[num1] = true;
                arr[count] = num1;
                DFS(arr, ch, id + 1, count + 1);
                ch[num1] = false;
            }
            if (id + 1 < str.length()) {
                int num2 = num1 * 10 + str.charAt(id + 1) - '0';
                if (num2 < 51 && !ch[num2]) {
                    ch[num2] = true;
                    arr[count] = num2;
                    DFS(arr, ch, id + 2, count + 1);
                    ch[num2] = false;
                }
            }
        }
    }
}