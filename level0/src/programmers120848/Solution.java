package programmers120848;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(3628800));
    }

    public static int solution(int n) {
        int answer = 0;
        int[] number = new int[10];
        number[0] = 1;
        for (int i = 1; i < number.length; i++) {
            number[i] = number[i-1] * (i+1);
        }
        for (int j = 0; j < number.length; j++) {
            if(number[j] > n) {
                answer = j;
                break;
            } else if (number[j] == n) {
                answer = j + 1;
                break;
            }
        }
        return answer;
    }
}
