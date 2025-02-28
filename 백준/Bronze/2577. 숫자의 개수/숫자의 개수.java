class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int multiply = read() * read() * read();
        
        int[] arr = new int[10];
        while (multiply > 0) {
            arr[multiply % 10]++;
            multiply /= 10;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i: arr) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}