package LAB5;

import java.io.*;
import java.util.*;

public class EILOCAL2 {

    public static void main(String[] args) {
        int n = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            vertexs[u].addLink(new Edge(vertexs[v], weight));
            vertexs[v].addLink(new Edge(vertexs[u], weight));
        }
        dfs(vertexs[0]);
        System.out.println(max);
    }

    static int max = 0;

    static void dfs(Vertex v) {
        v.check = true;
        for (var e : v.list) {
            if (!e.end.check) {
                e.end.weight = v.weight + e.weight;
                max = Math.max(max, e.end.weight);
                dfs(e.end);
            }
        }
    }

    static class Vertex {
        int id;
        int weight;
        boolean check = false;
        List<Edge> list = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addLink(Edge e) {
            list.add(e);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    static class Edge {
        Vertex end;
        int weight;

        public Edge(Vertex end, int weight) {
            this.end = end;
            this.weight = weight;
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