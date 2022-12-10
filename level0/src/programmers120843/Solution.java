package programmers120843;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int answer = solution(numbers, 3);
        System.out.println(answer);
    }

    public static int solution(int[] numbers, int k) {
        int answer = 0;
        for(int i = 0; i < k - 1; i++) {
            answer += 2;
            if(answer >= numbers.length) {
                answer = answer - numbers.length;
            }
        }
        return numbers[answer];
    }
}
