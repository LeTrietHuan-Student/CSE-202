package LAB5;

import java.io.*;
import java.util.*;

public class EIUMLMK2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = n - 1;
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i, (int) (sc.nextInt() * 0.15));
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertices[u].addNeighbor(vertices[v]);
            vertices[v].addNeighbor(vertices[u]);
        }

        dfs(vertices[0]);

        // for (Vertex ve : vertices) {
        // dfs(ve);
        // }
        for (int i = 0; i < n; i++) {
            sb.append(i).append(" ").append(vertices[i].commission).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(Vertex v) {
        v.visited = true;
        for (Vertex ver : v.adj) {

            if (!ver.visited) {
                ver.visited = true;
                if (ver.adj != null) {
                    dfs(ver);
                }
                v.commission += ver.commission * 0.5;
            }

        }

    }

    static class Vertex {
        int id;
        int commission;
        boolean visited;
        List<Vertex> adj = new ArrayList<>();

        public Vertex(int id, int commission) {
            this.id = id;
            this.commission = commission;
        }

        public void addNeighbor(Vertex v) {
            adj.add(v);
        }

    }

    // input Reader
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
