import java.io.*;

class Main {
    static int y, answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int h = Integer.parseInt(split[0]);
        y = Integer.parseInt(split[1]);
        DFS(h, 0);
        System.out.println(answer);
    }
    
    static void DFS(int money, int year) {
        if (year > y) return;
        if (year == y) {
            if (money > answer) answer = money;
            return;
        }
        DFS((int) (money * 1.05), year + 1);
        DFS((int) (money * 1.2), year + 3);
        DFS((int) (money * 1.35), year + 5);
    }
}