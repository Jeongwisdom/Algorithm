import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> hated = new HashMap<>();
        List<Integer> list;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            int hate = Integer.parseInt(st.nextToken());
            list = hated.getOrDefault(hate, new ArrayList<>());
            list.add(i);
            hated.put(hate, list);
        }
        list = hated.getOrDefault(p, new ArrayList<>());
        int answer = 0;
        boolean[] ch = new boolean[m + 1];
        while (list.size() > 0) {
            if (ch[list.get(0)]) {
                answer = -1;
                break;
            }
            ch[list.get(0)] = true;
            list = hated.getOrDefault(arr[list.get(0)], new ArrayList<>());
            answer++;
        }
        System.out.println(answer);
    }
}