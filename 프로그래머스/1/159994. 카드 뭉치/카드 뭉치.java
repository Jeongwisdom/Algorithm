class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        for (int i = 0, j = 0, k = 0; k < goal.length ; k++) {
            if (goal[k].equals(cards1[i])) i += i + 1 == cards1.length? 0: 1;
            else if (goal[k].equals(cards2[j])) j += j + 1 == cards2.length? 0: 1;
            else return "No";
        }
        
        return "Yes";
    }
}