class Solution {
    
    int answer;
    
    public int solution(int n, String[] data) {
        char[] order = new char[8];
        boolean[] ch = new boolean[8];
        answer = 0;
        
        DFS(0, data, order, ch);
        
        return answer;
    }
    
    public void DFS(int count, String[] data, char[] order, boolean[] ch) {
        char[] name = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        if (count == 8) {
            char c1, c2;
            int num, interval, id1, id2;
            boolean ch2 = true;
            for (int i = 0; i < data.length; i++) {
                c1 = data[i].charAt(0);
                c2 = data[i].charAt(2);
                num = data[i].charAt(4) - '0';
                id1 = 0;
                id2 = 0;
                for (int j = 0; j < order.length; j++) {
                    if (order[j] == c1) id1 = j;
                    if (order[j] == c2) id2 = j;
                }
                interval = Math.abs(id1 - id2) - 1;
                if (data[i].charAt(3) == '=') {
                    if (num != interval) {
                        ch2 = false;
                        break;
                    }
                } else if (data[i].charAt(3) == '<') {
                    if (num <= interval) {
                        ch2 = false;
                        break;
                    }
                } else {
                    if (num >= interval) {
                        ch2 = false;
                        break;
                    }
                }
            }
            if (ch2) answer++;
        } else {
            for (int i = 0; i < name.length; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    order[count] = name[i];
                    DFS(count + 1, data, order, ch);
                    ch[i] = false;
                }
            }
        }
    }
}