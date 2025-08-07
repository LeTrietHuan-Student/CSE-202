package LAB2;

import java.io.*;
import java.util.*;

public class Treasure2 {
    static int maxHeight = 0;

    public static void main(String[] args) {

        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int j = 0; j < n; j++) {
            vertexs[j] = new Vertex(j);
        }
        for (int j = 0; j < m; j++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].add(vertexs[v]);
            if (v == 0) {
                vertexs[u].containZero = true;
            }
        }
        bfs(vertexs[0]);
        int index = 0;
        int min = Integer.MAX_VALUE;
        for (Vertex vertex : vertexs) {
            if (vertex.myList.size() > 2 && vertex.containZero) {
                if (vertex.myList.size() < min) {
                    min = vertex.myList.size();
                    index = vertex.id;
                }
            }
        }

        for (int vertex : vertexs[index].myList) {
            sb.append(vertex).append(" ");
        }

        System.out.println(sb);

    }

    static void bfs(Vertex v) {
        Queue<Vertex> queue = new LinkedList<>();
        v.visited = true;
        queue.add(v);

        while (!queue.isEmpty()) {

            Vertex u = queue.poll();
            u.myList.add(u.id);
            for (Vertex w : u.adj) {

                if (!w.visited) {
                    w.visited = true;
                    queue.add(w);
                    w.myList.addAll(u.myList);
                }
            }
        }

    }

    static class Vertex {
        int id;
        boolean containZero;
        boolean visited;

        List<Vertex> adj = new ArrayList<>();
        List<Integer> myList = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;

        }

        public void add(Vertex v) {
            adj.add(v);
        }

        @Override
        public String toString() {
            return " ";
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
