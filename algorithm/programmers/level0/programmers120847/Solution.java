package programmers.level0.programmers120847;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {0, 31, 24, 10, 1, 9};
        int answer = solution(numbers);
        int answer2 = solution2(numbers);
        System.out.println(answer);
        System.out.println(answer2);
    }

    public static int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length-1] * numbers[numbers.length-2];
    }

    public static int solution2(int[] numbers) {
        int answer;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if(numbers[j] > numbers[j+1]) {
                    answer = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = answer;
                }
            }
        }
        return numbers[numbers.length-1] * numbers[numbers.length-2];
    }
}
