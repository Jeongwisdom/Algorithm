class Main {
    static long read() throws Exception {
        long c, n = System.in.read();
        boolean minus = false;
        if (n > 47) n = n & 15;
        else {
            minus = true;
            n = 0;
        }
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return minus? -n: n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = (int) read(), m = (int) read(), k = (int) read();
        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = read();
        }
        SegmentTree tree = new SegmentTree(n);
        tree.init(arr, 1, 1, n);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            int a = (int) read(), b = (int) read();
            long c = read();
            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                tree.update(1, 1, n, b, diff);
            } else {
                sb.append(tree.sum(1, 1, n, b, (int) c)).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}

class SegmentTree {
    long[] trees;
    int size;
    
    public SegmentTree(int arrSize) {
        int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
        this.size = 1 << (h + 1);
        this.trees = new long[size];
    }
    
    public long init(long[] arr, int id, int start, int end) {
        if (start == end) return trees[id] = arr[start];
        return trees[id] = init(arr, id * 2, start, (start + end) / 2) + init(arr, id * 2 + 1, (start + end) / 2 + 1, end);
    }
    
    public void update(int id, int start, int end, int updateId, long diff) {
        if (updateId < start || updateId > end) return;
        trees[id] += diff;
        if (start != end) {
            update(id * 2, start, (start + end) / 2, updateId, diff);
            update(id * 2 + 1, (start + end) / 2 + 1, end, updateId, diff);
        }
    }
    
    public long sum(int id, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && right >= end) return trees[id];
        return sum(id * 2, start, (start + end) / 2, left, right) + sum(id * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }
}