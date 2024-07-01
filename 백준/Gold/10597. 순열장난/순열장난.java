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
            for (int i = 1; i < 3; i++) {
                if (id + i > str.length()) break;
                int num = Integer.parseInt(str.substring(id, id + i));
                if (num < 51 && !ch[num]) {
                    ch[num] = true;
                    arr[count] = num;
                    DFS(arr, ch, id + i, count + 1);
                    ch[num] = false;
                }
            }
        }
    }
}