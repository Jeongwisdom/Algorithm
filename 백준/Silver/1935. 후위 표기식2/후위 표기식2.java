import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(br.readLine());
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Stack<Double> s = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) < 49) {
                double a = s.pop();
                double b = s.pop();
                if (sb.charAt(i) == '+') s.push(b + a);
                else if (sb.charAt(i) == '-') s.push(b - a);
                else if (sb.charAt(i) == '*') s.push(b * a);
                else s.push(b / a);
            } else s.push(arr[sb.charAt(i) - 'A']);
        }
        System.out.printf("%.2f", s.pop());
    }
}