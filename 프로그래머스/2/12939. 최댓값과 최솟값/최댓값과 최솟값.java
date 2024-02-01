class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, Integer.parseInt(arr[i]));
            max = Math.max(max, Integer.parseInt(arr[i]));
        }
        
        return String.valueOf(min + " " + max);
    }
}