import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Node head = new Node();
            Node now = head;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == '<') {
                    if (now.prev != null) now = now.prev;
                } else if (c == '>') {
                    if (now.next != null) now = now.next;
                } else if (c == '-') {
                    if (now.prev != null) {
                        if (now.next != null) now.next.prev = now.prev;
                        now.prev.next = now.next;
                        now = now.prev;
                    }
                } else {
                    now = new Node(c, now, now.next);
                    now.prev.next = now;
                    if (now.next != null) now.next.prev = now;
                }
            }
            now = head;
            while (now.next != null) {
                now = now.next;
                sb.append(now.value);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

class Node {
    char value = 0;
    Node prev = null;
    Node next = null;
    
    Node() {}
    
    Node(char value, Node prev, Node next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}