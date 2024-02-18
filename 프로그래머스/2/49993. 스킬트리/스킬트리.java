class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        StringBuilder match = new StringBuilder();
        match.append("[^").append(skill).append("]");
        for (String str: skill_trees) {
            str = str.replaceAll(match.toString(), "");
            if (skill.startsWith(str)) answer++;
        }

        return answer;
    }
}