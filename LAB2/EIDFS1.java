package LAB2;

import java.io.*;
import java.util.*;

public class EIDFS1 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Vertex[] gragh = readGraghVertexs(n, m);

        dfs(gragh[0]);

        System.out.println(sb);
    }

    static void dfs(Vertex v) {
        v.flag = true;
        sb.append(v.id).append(" ");
        for (Vertex x : v.adj) {
            if (!x.flag) {
                dfs(x);
            }
        }
    }

    static Vertex[] readGraghVertexs(int nVertice, int nEdges) {
        Vertex[] vertices = new Vertex[nVertice];
        for (int i = 0; i < nVertice; ++i) {
            vertices[i] = new Vertex(i);
        }
        // Read Edges
        for (int i = 0; i < nEdges; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertices[u].addNeighbor(vertices[v]); // Có Hướng
            vertices[v].addNeighbor(vertices[u]); // Vô hướng
        }

        for (Vertex v : vertices) {
            Collections.sort(v.adj, (v1, v2) -> (v1.id - v2.id));
        }
        return vertices;
    }

    static class Vertex {
        int id;
        boolean flag;
        List<Vertex> adj = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addNeighbor(Vertex v) {
            adj.add(v);
        }

    }

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