class Solution {
    public int solution(String[] babbling) {
        String[] pronunciation = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for (String s: babbling) {
            for (String pron: pronunciation) {
                if (s.contains(pron + pron)) break;
                s = s.replaceAll(pron, " ");
            }
            if (s.isBlank()) answer++;
        }
        
        return answer;
    }
}