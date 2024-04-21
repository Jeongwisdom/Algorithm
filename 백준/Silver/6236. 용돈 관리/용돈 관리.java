class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[] arr = new int[n];
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            max += arr[i];
            if (min < arr[i]) min = arr[i];
        }
        
        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 1;
            int money = mid;
            for (int i = 0; i < n; i++) {
                if (money < arr[i]) {
                    count++;
                    money = mid - arr[i];
                } else money -= arr[i];
            }
            if (count > m) min = mid + 1;
            else max = mid - 1;
        }
        System.out.println(min);
    }
    
    static int read() throws Exception{
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}