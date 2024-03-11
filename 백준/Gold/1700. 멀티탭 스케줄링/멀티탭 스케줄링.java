import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            if (q.contains(arr[i])) continue;
            if (q.size() >= n) {
                List<Integer> l = new ArrayList<>();
                for (int j = i + 1; j < k; j++) {
                    l.add(arr[j]);
                }
                int num = 0;
                int id = -1;
                for (int tab: q) {
                    if (!l.contains(tab)) {
                        num = tab;
                        break;
                    } else {
                        int tmp = l.indexOf(tab);
                        if (tmp > id) {
                            id = tmp;
                            num = tab;
                        }
                    }
                }
                q.remove(num);
                answer++;
            }
            q.offer(arr[i]);
        }
        System.out.println(answer);
    }
}