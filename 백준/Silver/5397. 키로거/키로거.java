import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);

        Node head, current, node;
        while (n-- > 0) {
            head = new Node();
            current = head;
            while ((c = System.in.read()) > 44) {
                switch(c) {
                    case 60:
                        if (current.pre == null) break;
                        current = current.pre;
                        break;
                    case 62:
                        if (current.next == null) break;
                        current = current.next;
                        break;
                    case 45:
                        if (current.pre == null) break;
                        current.pre.next = current.next;
                        if (current.next != null) current.next.pre = current.pre;
                        current = current.pre;
                        break;
                    default:
                        node = new Node((char) c, current);
                        node.next = current.next;
                        if (current.next != null) current.next.pre = node;
                        current.next = node;
                        current = node;
                }
            }

            head = head.next;
            while (head != null) {
                bw.write(head.data);
                head = head.next;
            }
            bw.write("\n");
        }
        bw.flush();
    }
}

class Node {
    char data;
    Node pre, next;

    Node() {}

    Node(char data, Node pre) {
        this.data = data;
        this.pre = pre;
    }
}