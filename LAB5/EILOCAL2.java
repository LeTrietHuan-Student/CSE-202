package LAB5;

import java.io.*;
import java.util.*;

public class EILOCAL2 {

    static int maxDistance = 0;

    public static void main(String[] args) {

        int n = sc.nextInt();
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < vertices.length - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int length = sc.nextInt();
            vertices[u].add(new Edge(length, vertices[v]));
            vertices[v].add(new Edge(length, vertices[u]));
        }
        dfs(vertices[0]);
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
        List<Edge> adj = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void add(Edge v) {
            adj.add(v);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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