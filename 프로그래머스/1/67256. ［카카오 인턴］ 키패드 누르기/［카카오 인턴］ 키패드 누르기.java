import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        Map<Integer, Position> map = new HashMap<>();
        for (int i = 0, index = 1; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map.put(index, new Position(i, j));
                index++;
            }
        }
        map.put(0, new Position(3, 1));
        
        Position left = new Position(3, 0);
        Position right = new Position(3, 2);
        for (int i : numbers) {
            switch (i) {
                case 1, 4, 7:
                    answer.append("L");
                    left = map.get(i);
                    break;
                case 3, 6, 9:
                    answer.append("R");
                    right = map.get(i);
                    break;
                case 2, 5, 8, 0:
                    int lengthL = calculate(i, left, map);
                    int lengthR = calculate(i, right, map);
                    if (lengthL > lengthR) {
                        answer.append("R");
                        right = map.get(i);
                    } else if (lengthL < lengthR) {
                        answer.append("L");
                        left = map.get(i);
                    } else {
                        if (hand.equals("left")) {
                            answer.append("L");
                            left = map.get(i);
                        } else {
                            answer.append("R");
                            right = map.get(i);
                        }
                    }
            }
        }
        
        return answer.toString();
    }
    
    public int calculate(int i, Position p1, Map<Integer, Position> map) {
        Position p2 = map.get(i);
        int x = Math.abs(p1.x - p2.x);
        int y = Math.abs(p1.y - p2.y);
        
        return x + y;
    }
}

class Position {
    int x;
    int y;
    
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}