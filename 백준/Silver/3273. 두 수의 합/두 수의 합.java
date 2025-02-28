class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        boolean[] arr = new boolean[1000001];
        for (int i = 0; i < n; i++) {
            arr[read()] = true;
        }
        int x = read();
        
        int answer = 0;
        for (int i = x / 2 + 1; i < 1000001; i++) {
            int remain = x - i;
            if (remain <= 0) break;
            if (arr[i] && arr[remain]) answer++;
        }
        System.out.println(answer);
    }
}