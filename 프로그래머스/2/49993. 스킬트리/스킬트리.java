class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        boolean ch;
        for (String str: skill_trees) {
            ch = true;
            for (int i = 0, j = 0; i < str.length(); i++) {
                if (skill.contains(String.valueOf(str.charAt(i)))) {
                    if (str.charAt(i) == skill.charAt(j)) j++;
                    else {
                        ch = false;
                        break;
                    }
                }
            }
            if (ch) answer++;
        }

        return answer;
    }
}