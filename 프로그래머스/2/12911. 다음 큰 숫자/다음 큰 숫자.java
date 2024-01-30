class Solution {
    public int solution(int n) {
        int num = getOneNumber(n);
        int two;
        
        while (true) {
            n++;
            two = getOneNumber(n);
            if (num == two) return n;
        }
    }
    
    public int getOneNumber(int n) {
        String two = Integer.toBinaryString(n);
        int count = 0;
        
        for (int i = 0; i < two.length(); i++) {
            if (two.charAt(i) == '1') count++;
        }
        
        return count;
    }
}