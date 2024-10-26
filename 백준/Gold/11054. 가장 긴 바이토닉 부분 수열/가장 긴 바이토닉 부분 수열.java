class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        int[] up = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            up[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j]) up[i] = Math.max(up[i], up[j] + 1);
            }
        }
        
        int[] down = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            down[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) down[i] = Math.max(down[i], down[j] + 1);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, up[i] + down[i] - 1);
        }
        System.out.println(answer);
    }
}