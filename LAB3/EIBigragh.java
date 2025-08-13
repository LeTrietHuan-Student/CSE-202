package LAB3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class EIBigragh {
    static int maxDistance = 0;

    public static void main(String[] args) {

        int t = sc.nextInt();

        for (int j = 0; j < t; j++) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            Vertex[] vertexs = new Vertex[n];

            for (int i = 0; i < vertexs.length; i++) {
                vertexs[i] = new Vertex(i);
            }
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                vertexs[u].add(vertexs[v]);
                vertexs[v].add(vertexs[u]);
            }
            boolean flag = true;
            for (Vertex vertex : vertexs) {
                if (!vertex.visited) {
                    if (!bfs(vertex)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                sb.append("Yes");
            } else {
                sb.append("No");
            }
            sb.append("\n");

        }
        System.out.println(sb);

    }

    static boolean bfs(Vertex v) {
        Queue<Vertex> queue = new LinkedList<>();
        v.visited = true;
        v.group = 0;
        queue.add(v);
        while (!queue.isEmpty()) {
            Vertex w = queue.poll();
            for (Vertex u : w.adj) {
                if (!u.visited) {
                    u.visited = true;
                    u.group = (w.group == 0) ? 1 : 0;
                    queue.add(u);
                } else if (u.group == w.group) {
                    return false;
                }
            }

        }
        return true;

    }

    static class Vertex {
        int id;
        int group;
        boolean visited;

        List<Vertex> adj = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;

        }

        public void add(Vertex v) {
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
