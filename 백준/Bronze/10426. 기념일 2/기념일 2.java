import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String[] split = br.readLine().split(" ");
        Date date = format.parse(split[0]);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int days = Integer.parseInt(split[1]) - 1;
        calendar.add(Calendar.DATE, days);
        System.out.println(format.format(calendar.getTime()));
    }
}