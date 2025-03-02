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
            switch (str.charAt(0)) {
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
                    node = new Node(str.charAt(2), current);
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