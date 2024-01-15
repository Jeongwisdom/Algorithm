package programmers.level0.programmers120844;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {4, 455, 6, 4, -1, 45, 6};
        int[] answer = solution(numbers, "left");
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        if(direction.equals("right")) {
            answer[0] = numbers[numbers.length-1];
            System.arraycopy(numbers, 0, answer, 1, numbers.length - 1);
        } else {
            answer[numbers.length - 1] = numbers[0];
            System.arraycopy(numbers, 1, answer, 0, numbers.length - 1);
        }
        return answer;
    }
}
