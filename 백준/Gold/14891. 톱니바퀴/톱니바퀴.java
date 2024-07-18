import java.io.*;

class Main {
    static int[][] arr = new int[5][8];
    static int[] firstId = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int n = Integer.parseInt(br.readLine());
        int idx, direction;
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            idx = Integer.parseInt(split[0]);
            direction = Integer.parseInt(split[1]);
            rotateLeft(idx, direction);
            rotateRight(idx, direction);
            rotate(idx, direction);
        }

        int answer = 0;
        for (int i = 1, plus = 1; i < 5; i++, plus *= 2) {
            if (arr[i][firstId[i]] == 1) answer += plus;
        }
        System.out.println(answer);
    }

    static void rotate(int idx, int direction) {
        if (direction == 1) {
            firstId[idx] = (firstId[idx] + 7) % 8;
        } else {
            firstId[idx] = (firstId[idx] + 1) % 8;
        }
    }

    static void rotateLeft(int idx, int direction) {
        if (idx == 1) return;
        int id = (firstId[idx] + 6) % 8;
        int next = (firstId[idx - 1] + 2) % 8;
        if (arr[idx][id] != arr[idx - 1][next]) {
            int dir = direction * -1;
            rotateLeft(idx - 1, dir);
            rotate(idx - 1, dir);
        }
    }

    static void rotateRight(int idx, int direction) {
        if (idx == 4) return;
        int id = (firstId[idx] + 2) % 8;
        int next = (firstId[idx + 1] + 6) % 8;
        if (arr[idx][id] != arr[idx + 1][next]) {
            int dir = direction * -1;
            rotateRight(idx + 1, dir);
            rotate(idx + 1, dir);
        }
    }
}