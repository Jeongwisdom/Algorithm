class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String a = Long.toString(numbers[i], 2);
            StringBuilder sb = new StringBuilder(a);
            int id = a.lastIndexOf("0");
            if (id != -1) {
                sb.setCharAt(id, '1');
                if (id != a.length() - 1) {
                    sb.setCharAt(id + 1, '0');
                }
            } else {
                if (numbers[i] == 0) sb = new StringBuilder("1");
                else sb.insert(1, '0');
            }
            answer[i] = Long.parseLong(sb.toString(), 2);
        }
        
        return answer;
    }
}