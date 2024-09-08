import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        long x = Integer.parseInt(split[0]);
        long y = Integer.parseInt(split[1]);
        long w = Integer.parseInt(split[2]);
        long s = Integer.parseInt(split[3]);
        long min = x < y? x: y;
        long max = x < y? y: x;
        long answer;
        if (2 * w > s) {
            answer = min * s;
            if (w > s) answer += (max - min) / 2 * 2 * s + (max - min) % 2 * w;
            else answer += (max -min) * w;
        } else answer = w * (x + y);
        System.out.println(answer);
    }
}