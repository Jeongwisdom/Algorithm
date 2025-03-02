import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node current, node, head = new Node();
        current = head;
        for (char c: br.readLine().toCharArray()) {
            node = new Node(c, current);
            current.next = node;
            current = node;
        }

        int m = Integer.parseInt(br.readLine());
        String str;
        while (m-- > 0) {
            str = br.readLine();
            char command = str.charAt(0);
            if (command == 'L') {
                if (current.pre != null) current = current.pre;
            }
            else if (command == 'D') {
                if (current.next != null) current = current.next;
            }
            else if (command == 'B') {
                if (current.pre != null) {
                    current.pre.next = current.next;
                    if (current.next != null) current.next.pre = current.pre;
                    current = current.pre;
                }
            }
            else if (command == 'P') {
                char c = str.charAt(2);
                node = new Node(c, current);
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