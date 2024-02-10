class Solution {
    public int[] solution(int brown, int yellow) {
        int j;
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                j = yellow / i;
                if ((i + 2) * (j + 2) - yellow == brown) {
                    return new int[] {j + 2, i + 2};
                }
            }
        }
        
        return null;
    }
}