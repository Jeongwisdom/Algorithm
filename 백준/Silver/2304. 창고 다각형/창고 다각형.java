import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = read();
            }
        }
        Arrays.sort(arr, (a1, a2) -> a1[0] - a2[0]);
        Stack<int[]> s = new Stack<>();
        s.push(new int[] {arr[0][0], arr[0][1]});
        int id = 0;
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (s.peek()[1] < arr[i][1]) {
                answer += s.peek()[1] * (arr[i][0] - s.peek()[0]);
                s.push(new int[] {arr[i][0], arr[i][1]});
                id = i;
            }
        }
        answer += s.peek()[1];
        for (int i = n - 1; i > id; i--) {
            int[] a = arr[i];
            while (i > id && a[1] > arr[i - 1][1]) i--;
            answer += (a[0] - arr[i - 1][0]) * a[1];
        }
        System.out.println(answer);
    }
}