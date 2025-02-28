class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        int x = read();
        
        int answer = 0;
        int[] num = new int[1000001];
        for (int i = 0; i < n; i++) {
            int remain = x - arr[i];
            if (remain >= 0 && remain <= 1000000) {
                if (num[remain] > 0) {
                    answer++;
                    num[remain]--;
                }
            }
            num[arr[i]]++;
        }
        System.out.println(answer);
    }
}