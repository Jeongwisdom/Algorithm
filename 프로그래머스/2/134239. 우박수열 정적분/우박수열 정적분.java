import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        List<Double> list = new ArrayList<>();
        while (k > 1) {
            double area = k;
            if (k % 2 == 0) k /= 2;
            else k = k * 3 + 1;
            double square = k > area? area: k;
            area = Math.abs(area - k) / 2 + square;
            list.add(area);
        }
        
        double[] answer = new double[ranges.length];
        int size = list.size();
        for (int i = 0; i < answer.length; i++) {
            int l = ranges[i][0];
            int r = size + ranges[i][1];
            if (l > r) answer[i] = -1;
            else {
                double sum = 0.0;
                for (int j = l; j < r; j++) {
                    sum += list.get(j);
                }
                answer[i] = sum;
            }
        }
        
        return answer;
    }
}