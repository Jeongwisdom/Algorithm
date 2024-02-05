import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Set<String> set = new HashSet<>();
        Set<String> answer = new HashSet<>();
        int s = Integer.parseInt(st.nextToken().replace(":", ""));
        int e = Integer.parseInt(st.nextToken().replace(":", ""));
        int q = Integer.parseInt(st.nextToken().replace(":", ""));
        String command = "";
        
        while ((command = br.readLine()) != null) {
            st = new StringTokenizer(command, " ");
            int time = Integer.parseInt(st.nextToken().replace(":", ""));
            String name = st.nextToken();
            
            if (time <= s) {
                set.add(name);
            }
            
            if (time >= e && time <= q && set.contains(name)) {
                answer.add(name);
            }
        }
        
        System.out.println(answer.size());
    }
}