import java.io.*;
import java.util.*;

public class EIHCON {
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int queries = sc.nextInt();

        Vertex[] vertexs = new Vertex[n + 1];
        for (int i = 1; i < vertexs.length; i++) {
            vertexs[i] = new Vertex(i);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[v].adj.add(vertexs[u]);
        }

        for (int i = 0; i < queries; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (isThereAPath(vertexs, a, b)) {
                sb.append("Y");
            } else {
                sb.append("N");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static boolean isThereAPath(Vertex[] vertexs, int a, int b) {
        if (vertexs[a].adj.contains(vertexs[b])) {
            return true;
        }
        for (Vertex v : vertexs[a].adj) {

            for (Vertex vertex : v.adj) {
                if (vertex.id == b) {
                    return true;
                }
            }
        }
        return false;
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
