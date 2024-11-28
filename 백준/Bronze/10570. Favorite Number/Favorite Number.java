import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        Map<Integer, Integer> map;
        StringBuilder sb = new StringBuilder();
        int k, num;
        for (int i = 0; i < n; i++) {
            k = read();
            map = new HashMap<>();
            for (int j = 0; j < k; j++) {
                num = read();
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
            sortedEntries.sort((e1, e2) -> {
                if (Objects.equals(e2.getValue(), e1.getValue())) return e1.getKey() - e2.getKey();
                return e2.getValue() - e1.getValue();
            });
            sb.append(sortedEntries.get(0).getKey()).append("\n");
        }
        System.out.println(sb);
    }
}