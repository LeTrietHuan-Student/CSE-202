package LAB2;

import java.io.*;
import java.util.*;

public class EICONP1 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static int count;
    static int smallVertex;

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i, false);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertices[u].addNeighbor(vertices[v]);
            vertices[v].addNeighbor(vertices[u]);
        }

        for (int i = 0; i < vertices.length; i++) {
            if (!vertices[i].visited) {
                count = 1;
                smallVertex = vertices[i].id;
                dfs(vertices[i]);
                sb.append(smallVertex).append(" ").append(count).append("\n");

            }
        }

        System.out.println(sb);

    }

    static void dfs(Vertex v) {
        v.visited = true;
        smallVertex = Math.min(v.id, smallVertex);
        for (Vertex x : v.adj) {
            if (!x.visited) {
                dfs(x);
                count++;
            }
        }
    }

    static class Vertex {
        int id;
        boolean visited;
        List<Vertex> adj = new ArrayList<>();

        public Vertex(int id, boolean visited) {
            this.id = id;
            this.visited = visited;
        }

        public void addNeighbor(Vertex v) {
            adj.add(v);
        }

    }

    // InputReader

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
