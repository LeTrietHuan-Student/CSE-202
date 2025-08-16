package LAB4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIUEAPOST {

    public static void main(String[] args) {
        {

            var nNode = sc.nextInt();
            var nodes = ReadTree(nNode);
            PrintPostOrder(nodes[0]);
            System.out.print(sb);

        }
    }

    static StringBuilder sb = new StringBuilder();

    static void PrintPostOrder(Node node) {
        if (node.Left != null) {
            PrintPostOrder(node.Left);
        }

        if (node.Right != null) {
            PrintPostOrder(node.Right);
        }
        sb.append(node.Id).append(" ");

    }

    static Node[] ReadTree(int nNode) {
        Node[] nodes = new Node[nNode];
        for (var i = 0; i < nNode; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (var i = 0; i < nNode; i++) {
            var leftIndex = sc.nextInt();
            nodes[i].Left = leftIndex > 0 ? nodes[leftIndex - 1] : null;
            var rightIndex = sc.nextInt();
            nodes[i].Right = rightIndex > 0 ? nodes[rightIndex - 1] : null;
        }
        return nodes;
    }

    static class Node {

        public int Id;
        public Node Left;
        public Node Right;

        public Node(int id) {
            Id = id;
        }
    }

    static InputReader sc = new InputReader(System.in);

    static class InputReader {

        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
