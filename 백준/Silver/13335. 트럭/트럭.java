import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int time = 0;
        int sum = 0;
        int id = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < w; i++) dq.offer(0);
        while (id < n) {
            sum -= dq.poll();
            if (sum + arr[id] <= l) {
                sum += arr[id];
                dq.offer(arr[id++]);
            } else dq.offer(0);
            time++;
        }
        time += w;
        System.out.println(time);
    }
}