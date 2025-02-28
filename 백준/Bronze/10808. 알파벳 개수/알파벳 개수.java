class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[26];
        int c;
        while ((c = System.in.read()) >= 97) {
            arr[c - 97]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i: arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}