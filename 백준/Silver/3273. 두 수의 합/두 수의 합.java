class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[1000001];
        for (int i = 0; i < n; i++) {
            arr[read()]++;
        }
        int x = read();
        
        int mid = (x + 1) / 2;
        int answer = 0;
        if (x % 2 == 0) {
            answer += arr[mid] / 2;
            mid++;
        }
        for (int i = mid; i < 1000001; i++) {
            int remain = x - i;
            if (remain <= 0) break;
            answer += Math.min(arr[i], arr[remain]);
        }
        System.out.println(answer);
    }
}