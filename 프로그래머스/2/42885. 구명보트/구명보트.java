import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        
        for (int i = 0, j = people.length - 1; i < j; j--) {
            if (people[i] + people[j] <= limit) {
                answer++;
                i++;
            }
        }
        
        return people.length - answer;
    }
}