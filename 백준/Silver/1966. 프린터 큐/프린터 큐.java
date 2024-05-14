import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        List<int[]> l;
        int[] im;
        int t = read();
        for (int i = 0; i < t; i++) {
            int n = read();
            int m = read();
            l = new ArrayList<>();
            im = new int[n];
            for (int j = 0; j < n; j++) {
                int num = read();
                l.add(new int[] {j, num});
                im[j] = num;
            }
            Arrays.sort(im);
            int id = 0;
            int imId = n - 1;
            int c = 0;
            while (l.size() > 0) {
                if (id == l.size()) id = 0;
                if (l.get(id)[1] == im[imId]) {
                    c++;
                    imId--;
                    if (l.get(id)[0] == m) {
                        sb.append(c).append("\n");
                        break;
                    } else l.remove(id);
                } else id++;
            }
        }
        System.out.println(sb);
    }
}