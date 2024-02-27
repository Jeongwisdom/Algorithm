import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<Integer>> map = new TreeMap<>();
        for (String record: records) {
            String[] split = record.split(" ");
            List<Integer> list = map.getOrDefault(split[1], new ArrayList<>());
            String[] times = split[0].split(":");
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            list.add(time);
            map.put(split[1], list);
        }
        
        int[] answer = new int[map.size()];
        int i = 0;
        int last = 23 * 60 + 59;
        for (Map.Entry<String, List<Integer>> entry: map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() % 2 != 0)  list.add(last);
            double time = 0.0;
            for (int j = 0; j < list.size(); j += 2) {
                time += list.get(j + 1) - list.get(j);
            }
            if (time <= fees[0]) answer[i++] = fees[1];
            else answer[i++] = fees[1] + (int) Math.ceil((time - fees[0]) / fees[2]) * fees[3];
        }
        
        return answer;
    }
}