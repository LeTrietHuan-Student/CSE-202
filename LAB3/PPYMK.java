package LAB3;

import LAB3.EIFOLTRE.InputReader;
import LAB3.EIFOLTRE.Vertex;
import java.io.*;
import java.util.*;

public class EIFOLTRE {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    static Map<Integer, TreeSet<Integer>> map = new HashMap<>();

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

        int member = sc.nextInt();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {

        }

    }

    static void bfs(Vertex startVertex, Vertex[] vertexs) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startVertex);
        startVertex.level = 0;
        startVertex.visited = true;

        while (!queue.isEmpty()) {
            Vertex w = queue.poll();

            for (Vertex u : w.adj) {
                if (!u.visited) {
                    queue.add(u);
                    u.visited = true;
                    u.level += w.level + 1;
                    if (!map.containsKey(w.level + 1)) {
                        TreeSet<Integer> mySet = new TreeSet<>();
                        map.put(w.level + 1, mySet);
                    }
                    TreeSet<Integer> myTreeSet = map.get(w.level + 1);
                    myTreeSet.add(u.id);

                }
            }
        }
    }

    static class Vertex {
        int id;
        boolean visited;
        int level;
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
