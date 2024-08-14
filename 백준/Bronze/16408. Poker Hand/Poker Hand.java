import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
        int[][] arr = new int[13][2];
        for (int i = 0; i < 13; i++) {
            arr[i][0] = c[i];
        }
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 13; j++) {
                if (split[i].charAt(0) == arr[j][0]) {
                    arr[j][1]++;
                    break;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < 13; i++) {
            if (answer < arr[i][1]) answer = arr[i][1];
        }
        System.out.println(answer);
    }
}