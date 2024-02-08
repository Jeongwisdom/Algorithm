import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        List<Character> list2;
        for (int i = 0; i < n; i++) {
            list2 = list.get(i);
            for (int j = m - 1; j >=0; j--) {
                list2.add(board[j].charAt(i));
            }
            list.set(i, list2);
        }

        int[] x = {-1, -1, 0};
        int[] y = {-1, 0, -1};
        Set<Point> set = new TreeSet<>();
        Set<int[]> tmp;
        set.add(new Point(0, 0));

        char c;
        while (!set.isEmpty()) {
            set = new TreeSet<>();
            for (int i = 1; i < list.size(); i++) {
                for (int j = 1; j < list.get(i).size(); j++) {
                    tmp = new HashSet<>();
                    c = list.get(i).get(j);
                    tmp.add(new int[] {i, j});
                    for (int k = 0; k < x.length; k++) {
                        if (j + y[k] >= list.get(i + x[k]).size() || list.get(i + x[k]).get(j + y[k]) != c) break;
                        tmp.add(new int[] {i + x[k], j + y[k]});
                    }
                    if (tmp.size() == 4) {
                        for (int[] l: tmp) {
                            set.add(new Point(l[0], l[1]));
                        }
                    }
                }
            }

            for (Point p: set) {
                list2 = list.get(p.x);
                list2.remove(p.y);
                list.set(p.x, list2);
                answer++;
            }
        }

        return answer;
    }
}

class Point implements Comparable<Point> {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (this.x == p.x) return p.y - this.y;
        return p.x - this.x;
    }
}