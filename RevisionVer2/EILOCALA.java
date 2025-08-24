package RevisionVer2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EILOCALA {
    static InputReader sc = new InputReader(System.in);
    static int minIndex = 0;
    static int max = 0;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = n - 1;
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            vertices[u].addNeighbor(new Edge(weight, vertices[v]));
            vertices[v].addNeighbor(new Edge(weight, vertices[u]));
        }
        int min1 = dfs(vertices[0]);
        for (var e : vertices) {
            e.visited = false;
            e.weight = 0;
        }
        int min2 = dfs(vertices[min1]);

        System.out.println(Math.min(min1, min2) + " " + max);

    }

    static int dfs(Vertex v) {
        v.visited = true;
        if (v.weight > max) {
            minIndex = v.id;
            max = v.weight; // xac dinh max
        }
        for (var ve : v.adj) {
            if (!ve.end.visited) {
                ve.end.weight = v.weight + ve.weight;
                dfs(ve.end);
            }
        }
        return minIndex;
    }

    static class Vertex {
        int id;
        int weight;
        boolean visited;
        List<Edge> adj = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addNeighbor(Edge v) {
            adj.add(v);
        }

    }

    static class Edge {
        int weight;
        Vertex end;

        public Edge(int weight, Vertex end) {
            this.weight = weight;
            this.end = end;
        }

    }

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
