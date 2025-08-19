package LAB5;

import java.io.*;
import java.util.*;

public class EiuBTW {

    public static void main(String[] args) {
        int n = sc.nextInt();
        int root = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < vertices.length - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertices[u].addLink(vertices[v]);
            vertices[v].addLink(vertices[u]);
            vertices[u].isRoot = true;
        }
        int leaves = 0;
        for (Vertex vertex : vertices) {
            if (!vertex.isRoot) {
                leaves++;
            }
        }
        for (int i = 0; i < leaves; i++) {
            vertices[sc.nextInt()].tree = sc.nextInt();
        }
        dfs(vertices[root]);
        for (Vertex ver : vertices) {
            sb.append(ver.id).append(" ").append(ver.tree).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(Vertex v) {
        v.check = true;
        for (Vertex ver : v.list) {
            if (!ver.check) {
                dfs(ver);
                v.tree += ver.tree;
            }
        }
    }

    static class Vertex {

        int id;
        boolean check;
        boolean isRoot;
        int tree;
        ArrayList<Vertex> list = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
            this.check = false;
        }

        public void addLink(Vertex v) {
            list.add(v);
        }
    }

    static InputReader sc = new InputReader(System.in);

    static class InputReader {

        StringTokenizer tokenizer;
        BufferedReader reader;
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
