class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean minus = false;
        if (n == 13) {
            minus = true;
            n = 0;
        }
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        if (minus) n *= -1;
        return n;
    }

    public static void main(String[] args) throws Exception {
        int n = read();
        Node head = new Node();
        Node now = head;
        for (int i = 1; i <= n; i++) {
            now = new Node(i, read(), now);
            now.prev.next = now;
        }
        now.next = head.next;
        head.next.prev = now;
        StringBuilder sb = new StringBuilder();
        int id = 0;
        now = head.next;
        int c = 0;
        while (c < n) {
            int count = 0;
            while (count < id) {
                now = now.next;
                count++;
            }
            while (id < count - 1) {
                now = now.prev;
                count--;
            }
            sb.append(now.id).append(" ");
            id = now.val;
            now.prev.next = now.next;
            now.next.prev = now.prev;
            now = now.prev;
            c++;
        }
        System.out.println(sb);
    }
}

class Node {
    int id = -1;
    int val;
    Node prev;
    Node next;
    
    Node() {}
    
    Node(int id, int val, Node prev) {
        this.id = id;
        this.val = val;
        this.prev = prev;
    }
}