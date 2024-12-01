import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        for (int i = 1; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < arr.length; j++) {
                if (str.charAt(j) != arr[j]) {
                    arr[j] = '?';
                }
            }
        }
        
        System.out.println(arr);
    }
}