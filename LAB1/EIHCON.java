import java.io.*;
import java.util.*;

public class EIHCON {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        Vertex[] vertices = seeGraghVertexs(n, m);
        for (int i = 0; i < p; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Vertex VA = vertices[a];
            Vertex VB = vertices[b];
            if (VA.ajencentVertices.contains(VB)) {
                sb.append("Y").append("\n");
            } else {
                sb.append("N").append("\n");
            }
        }
        System.out.println(sb);
    }

    static Vertex[] seeGraghVertexs(int nVertices, int nEdges) {
        Vertex[] vertices = new Vertex[nVertices + 1];
        for (int i = 1; i < vertices.length; ++i) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < nEdges; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // Đồ thị vô hướng
            vertices[a].addNeighbor(vertices[b]);
        }
        return vertices;
    }

    static class Vertex {
        int id;
        List<Vertex> ajencentVertices = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addAdjecentVertex(Vertex vertex) {
            ajencentVertices.add(vertex);
        }

        public void addNeighbor(Vertex v) {
            ajencentVertices.add(v);
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
