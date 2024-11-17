import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<BigInteger> list = new ArrayList<>();
        String str;
        for (int i = 0; i < n; i++) {
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                int k;
                for (k = j; k < str.length(); k++) {
                    if (str.charAt(k) > 57) break;
                }
                if (j != k) {
                    list.add(new BigInteger(str.substring(j, k)));
                }
                j = k;
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (BigInteger num: list) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}