import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        String[] date = split[0].split("-");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        int d = Integer.parseInt(split[1]) - 1;
        day += d;
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while (true) {
            if (month == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
                days[2] = 29;
            } else {
                days[2] = 28;
            }
            if (day <= days[month]) break;
            day -= days[month];
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
        System.out.printf("%04d-%02d-%02d%n", year, month, day);
    }
}
