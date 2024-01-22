class Solution {
    public int solution(int[][] sizes) {
        int wMax = 0;
        int hMax = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            wMax = Math.max(wMax, Math.max(sizes[i][0], sizes[i][1]));
            hMax = Math.max(hMax, Math.min(sizes[i][0], sizes[i][1]));
        }
        
        return wMax * hMax;
    }
}