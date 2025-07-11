import java.io.*;
import java.util.*;

class EIFACEBOOK {
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Vertex[] vertexs = new Vertex[n + 1];
        for (int i = 1; i < vertexs.length; i++) {
            String gender = sc.next();
            if (gender.equals("Nam")) {
                vertexs[i] = new Vertex(i, true);
            } else {
                vertexs[i] = new Vertex(i, false);
            }
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addNeighbor(vertexs[v]);
            vertexs[v].addNeighbor(vertexs[u]);
        }

        for (int i = 1; i < vertexs.length; i++) {
            int count = 0;
            for (Vertex vertex : vertexs[i].adj) {
                if (vertexs[i].gender != vertex.gender) {
                    count++;
                }
            }
            sb.append(count).append(" ");
        }
        System.out.println(sb);

    }

    static class Vertex {
        int id;
        boolean gender;

        List<Vertex> adj = new ArrayList<>();

        public Vertex(int id, boolean gender) {
            this.id = id;
            this.gender = gender;
        }

        public void addNeighbor(Vertex v) {
            if (!adj.contains(v)) {
                adj.add(v);
            }

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
