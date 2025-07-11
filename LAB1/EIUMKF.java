import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EIUMKF {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
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

        for (Vertex v : vertexs) {
            sb.append(v);
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

        public void add(Vertex v) {
            adj.add(v);
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append(id).append(" ").append(adj.size()).append(" ");
            adj.sort((v1, v2) -> {
                return Integer.compare(v1.id, v2.id);
            });
            for (Vertex vertex : adj) {
                sb.append(vertex.id).append(" ");
            }
            return sb.toString();
        }

    }

    static InputReader sc = new InputReader(System.in);

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
