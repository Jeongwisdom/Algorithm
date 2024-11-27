import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String grade = br.readLine();
        String answer;
        if (grade.equals("A+")) {
            answer = "4.3";
        } else if (grade.equals("A0")) {
            answer = "4.0";
        } else if (grade.equals("A-")) {
            answer = "3.7";
        } else if (grade.equals("B+")) {
            answer = "3.3";
        } else if (grade.equals("B0")) {
            answer = "3.0";
        } else if (grade.equals("B-")) {
            answer = "2.7";
        } else if (grade.equals("C+")) {
            answer = "2.3";
        } else if (grade.equals("C0")) {
            answer = "2.0";
        } else if (grade.equals("C-")) {
            answer = "1.7";
        } else if (grade.equals("D+")) {
            answer = "1.3";
        } else if (grade.equals("D0")) {
            answer = "1.0";
        } else if (grade.equals("D-")) {
            answer = "0.7";
        } else {
            answer = "0.0";
        }
        System.out.println(answer);
    }
}