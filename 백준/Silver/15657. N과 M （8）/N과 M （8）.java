class Main {
    static int n, m;
    static int[] number, arr;
    static StringBuilder sb = new StringBuilder();

    static int read() throws Exception {
        int r, c = System.in.read() & 15;
        while ((r = System.in.read()) > 47) c = (c << 3) + (c << 1) + (r & 15);
        return c;
    }
    
    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        number = new int[n];
        for (int i = 0; i < n; i++) number[i] = read();
        arr = new int[m];
        quickSort(0, n - 1);
        DFS(0, 0);
        System.out.println(sb);
    }

    static void DFS(int id, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) sb.append(arr[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = id; i < n; i++) {
            arr[count] = number[i];
            DFS(i, count + 1);
        }
    }

    static void quickSort(int l, int r) {
        int pivot = partition(l, r);
        if (l < pivot - 1) quickSort(l, pivot - 1);
        if (pivot < r) quickSort(pivot, r);
    }

    static int partition(int l, int r) {
        int mid = number[(l + r) / 2];
        while (l <= r) {
            while (number[l] < mid) l++;
            while (mid < number[r]) r--;
            if (l <= r) {
                int tmp = number[l];
                number[l] = number[r];
                number[r] = tmp;
                l++;
                r--;
            }
        }
        return l;
    }
}