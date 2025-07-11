package LAB2;

import java.io.*;
import java.util.*;

public class EICONP {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] gragh = readGraghVertexs(n, m);
        for (int i = 0; i < gragh.length; i++) {
            if (!gragh[i].flag) {
                dfs(gragh[i]);
            }
        }
        System.out.println(count);
    }

    static int count;

    static void dfs(Vertex v) {
        v.flag = true;
        count++;
        for (Vertex x : v.adj) {
            if (!x.flag) {
                dfs(x);
            }
        }
    }

    static Vertex[] readGraghVertexs(int nVertice, int nEdges) {
        Vertex[] vertices = new Vertex[nVertice];
        for (int i = 0; i < vertices.length; ++i) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < nEdges; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertices[u].addNeighbor(vertices[v]);
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