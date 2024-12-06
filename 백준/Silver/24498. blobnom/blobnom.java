class Main {
    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        
        int answer = Math.max(arr[0], arr[n - 1]);
        for (int i = 2; i < n; i++) {
            answer = Math.max(answer, arr[i - 1] + Math.min(arr[i], arr[i - 2]));
        }
        System.out.println(answer);
    }
}