class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];

        int k;
        for (int i = 1; i <= end / 2 && i <= 10000000; i++) {
            k = (int) (begin + (begin % i == 0? 0: i - begin % i));
            k = k == i? k * 2: k;
            for (int j = (int) (k - begin); j < answer.length; j += i) {
                answer[j] = i;
            }
        }

        return answer;
    }
}