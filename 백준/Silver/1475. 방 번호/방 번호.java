class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[10];
        int n;
        while ((n = System.in.read()) > 47) {
            arr[n & 15]++;
        }

        int answer = (arr[6] + arr[9] + 1) / 2;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;
            answer = Math.max(answer, arr[i]);
        }
        System.out.println(answer);
    }
}