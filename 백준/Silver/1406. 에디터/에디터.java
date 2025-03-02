import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        Node current, node, head = new Node();
        current = head;
        int c;
        while ((c = System.in.read()) > 96) {
            node = new Node(c, current);
            current.next = node;
            current = node;
        }

        int m = System.in.read() & 15;
        while ((c = System.in.read()) > 47) m = (m << 3) + (m << 1) + (c & 15);

        while (m-- > 0) {
            switch (System.in.read()) {
                case 'L':
                    if (current.pre == null) break;
                    current = current.pre;
                    break;
                case 'D':
                    if (current.next == null) break;
                    current = current.next;
                    break;
                case 'B':
                    if (current.pre == null) break;
                    current.pre.next = current.next;
                    if (current.next != null) current.next.pre = current.pre;
                    current = current.pre;
                    break;
                case 'P':
                    System.in.read();
                    node = new Node(System.in.read(), current);
                    node.next = current.next;
                    if (current.next != null) current.next.pre = node;
                    current.next = node;
                    current = node;
            }
            System.in.read();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        head = head.next;
        while (head != null) {
            bw.write(head.data);
            head = head.next;
        }
        bw.flush();
    }
}

class Node {
    char data;
    Node pre, next;

    Node() {}

    Node(int data, Node pre) {
        this.data = (char) data;
        this.pre = pre;
    }
}