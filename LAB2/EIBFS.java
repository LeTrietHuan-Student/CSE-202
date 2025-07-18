package LAB2;

import java.io.*;
import java.util.*;

public class EIBFS {
    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] vertices = new Vertex[n];
        for (int idx = 0; idx < vertices.length; idx++) {
            vertices[idx] = new Vertex(idx, false);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertices[u].addNeighbor(vertices[v]);
        }

        for (Vertex v : vertices) {
            v.adj.sort((v1, v2) -> {
                return Integer.compare(v1.id, v2.id);
            });
        }
        bfs(vertices[0], vertices);
        System.out.println(sb);
    }

    static void bfs(Vertex v, Vertex[] vertices) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        v.visited = true;

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            sb.append(vertex.id).append(" ");
            for (Vertex w : vertex.adj) {
                if (!w.visited) {
                    queue.add(w);
                    w.visited = true;
                }
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

    // Input Reader
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
