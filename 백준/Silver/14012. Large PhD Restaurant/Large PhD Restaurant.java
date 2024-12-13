import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        long m = Long.parseLong(split[1]);
        String[] costs = br.readLine().split(" ");
        String[] pay = br.readLine().split(" ");
        List<Challenge> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Challenge(Integer.parseInt(costs[i]), Integer.parseInt(pay[i])));
        }
        list.sort((l1, l2) -> l1.cost - l2.cost);
        for (Challenge c : list) {
            if (m < c.cost) break;
            if (c.cost < c.pay) m += c.pay - c.cost;
        }
        System.out.println(m);
    }
}

class Challenge {
    int cost;
    int pay;
    
    public Challenge(int cost, int pay) {
        this.cost = cost;
        this.pay = pay;
    }
}