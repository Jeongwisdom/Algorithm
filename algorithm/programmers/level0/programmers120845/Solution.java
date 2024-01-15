package programmers.level0.programmers120845;

public class Solution {
    public static void main(String[] args) {
        int[] box = {10, 8, 6};
        int answer = solution(box, 3);
        System.out.println(answer);

    }


    public static int solution(int[] box, int n) {
        return (box[0]/n) * (box[1]/n) * (box[2]/n);
    }
}
