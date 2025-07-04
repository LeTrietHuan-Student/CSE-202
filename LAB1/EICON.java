
import java.io.*;
import java.util.*;

public class EICON {

    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        Vertex[] vertices = readGragh(n, m);
        for (int i = 0; i < q; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // Nếu a có cạnh tới b thì a nằm trong danh sách kề của b
            Vertex VA = vertices[a];
            Vertex VB = vertices[b];
            if (VA.adjencentVertices.contains(VB)) {
                sb.append("Y").append("\n");
            } else {
                sb.append("N").append("\n");
            }
        }
        System.out.println(sb);
    }

    static Vertex[] readGragh(int numberOfVertices, int numberOfEdges) {
        Vertex[] vertices = new Vertex[numberOfVertices + 1];
        for (int i = 1; i < vertices.length; ++i) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < numberOfEdges; ++i) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertices[v].addNeighbor(vertices[u]);
        }
        return vertices;
    }

    static class Vertex {
        int id;
        List<Vertex> adjencentVertices = new ArrayList();

        public Vertex(int id) {
            this.id = id;
        }

        public void addNeighbor(Vertex v) {
            adjencentVertices.add(v);
        }
    }

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
