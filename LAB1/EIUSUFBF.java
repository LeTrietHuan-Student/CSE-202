import java.io.*;
import java.util.*;

public class EIUSUFBF {
    public static void main(String[] args) {

        int n = sc.nextInt();
        int m = sc.nextInt();
        int minFriends = sc.nextInt();

        Vertex[] vertexs = new Vertex[n];

        for (int i = 0; i < vertexs.length; i++) {
            vertexs[i] = new Vertex(i);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            vertexs[u].addNeighbor(vertexs[v]);
            vertexs[v].addNeighbor(vertexs[u]);
        }
        for (Vertex vertex : vertexs) {
            vertex.adj.sort((v1, v2) -> {
                return Integer.compare(v1.id, v2.id);
            });
        }
        for (Vertex vertex : vertexs) {
            sb.append(vertex.id).append(" ");
            for (Vertex w : vertex.adj) {
                if (w.adj.size() < minFriends) {
                    sb.append(w.id).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Vertex {
        int id;
        List<Vertex> adj = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addNeighbor(Vertex v) {

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
