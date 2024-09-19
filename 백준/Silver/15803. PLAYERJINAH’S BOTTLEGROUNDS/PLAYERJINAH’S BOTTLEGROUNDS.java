import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double[][] arr = new double[3][2];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }
        double a = (arr[0][1] - arr[1][1]) / (arr[0][0] - arr[1][0]);
        double b = (arr[1][1] - arr[2][1]) / (arr[1][0] - arr[2][0]);
        double c = (arr[0][1] - arr[2][1]) / (arr[0][0] - arr[2][0]);
        if (a != b && b != c) System.out.println("WINNER WINNER CHICKEN DINNER!");
        else System.out.println("WHERE IS MY CHICKEN?");
    }
}