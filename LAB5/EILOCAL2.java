package LAB5;

import java.io.*;
import java.util.*;

public class EILOCAL2 {

    static int maxDistance = 0;

    public static void main(String[] args) {

        int n = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < vertexs.length; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < vertexs.length - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int length = sc.nextInt();
            vertexs[u].add(new Edge(length, vertexs[v]));
            vertexs[v].add(new Edge(length, vertexs[u]));
        }
        dfs(vertexs[0]);
        System.out.println(maxDistance);
    }

    static void dfs(Vertex v) {
        v.visited = true;

        for (Edge edge : v.adj) {
            if (!edge.end.visited) {
                edge.end.distanceFromRoot = v.distanceFromRoot + edge.length;
                maxDistance = Math.max(maxDistance, edge.end.distanceFromRoot);
                dfs(edge.end);
            }
        }

    }

    static class Edge {
        int length;
        Vertex end;

        public Edge(int length, Vertex end) {
            this.length = length;
            this.end = end;
        }
    }

    static class Vertex {

        int id;
        int distanceFromRoot;
        boolean visited;
        int day;
        List<Edge> adj = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void add(Edge v) {
            adj.add(v);
        }

    }

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

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