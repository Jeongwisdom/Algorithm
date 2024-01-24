class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int id ,min ,num;

        for (int i = 0; i < targets.length; i++) {
            id = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                min = Integer.MAX_VALUE;
                for (int k = 0; k < keymap.length; k++) {
                    num = keymap[k].indexOf(targets[i].charAt(j));
                    if (num != -1) min = Math.min(min, num + 1);
                }
                if (min == Integer.MAX_VALUE) {
                    id = -1;
                    break;
                } else id += min;
            }
            answer[i] = id;
        }

        return answer;
    }
}