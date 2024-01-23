class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for (int j = food[i] / 2; j > 0; j--) {
                sb.append(i);
            }
        }
        
        String origin = sb.toString();
        sb.append(0);
        sb.reverse();
        sb.insert(0, origin);
        
        return sb.toString();
    }
}