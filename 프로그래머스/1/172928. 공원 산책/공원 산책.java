class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        
        String[] route;
        int move;
        boolean ch;
        for (int i = 0; i < routes.length; i++) {
            ch = true;
            route = routes[i].split(" ");
            switch (route[0]) {
                case "E":
                    move = answer[1] + Integer.parseInt(route[1]);
                    if (move >= park[0].length()) break;
                    for (int j = answer[1] + 1; j <= move; j++) {
                        if (park[answer[0]].charAt(j) == 'X') {
                            ch = false;
                            break;
                        }
                    }
                    if (ch) {
                        answer[1] = move;
                    }
                    break;
                case "W":
                    move = answer[1] - Integer.parseInt(route[1]);
                    if (move < 0) break;
                    for (int j = answer[1] - 1; j >= move; j--) {
                        if (park[answer[0]].charAt(j) == 'X') {
                            ch = false;
                            break;
                        }
                    }
                    if (ch) {
                        answer[1] = move;
                    }
                    break;
                case "S":
                    move = answer[0] + Integer.parseInt(route[1]);
                    if (move >= park.length) break;
                    for (int j = answer[0] + 1; j <= move; j++) {
                        if (park[j].charAt(answer[1]) == 'X') {
                            ch = false;
                            break;
                        }
                    }
                    if (ch) {
                        answer[0] = move;
                    }
                    break;
                case "N":
                    move = answer[0] - Integer.parseInt(route[1]);
                    if (move < 0) break;
                    for (int j = answer[0] - 1; j >= move; j--) {
                        if (park[j].charAt(answer[1]) == 'X') {
                            ch = false;
                            break;
                        }
                    }
                    if (ch) {
                        answer[0] = move;
                    }
                    break;
            }
        }
        
        return answer;
    }
}