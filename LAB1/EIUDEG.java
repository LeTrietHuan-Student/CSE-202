import java.io.*;
import java.util.*;

public class EIUDEG {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Vertex[] gragh = readGragh();
        for (int i = 1; i < gragh.length; ++i) {
            Vertex v = gragh[i];
            sb.append(v.getDegree()).append(" ");
        }
        System.out.println(sb);
    }

    static Vertex[] readGragh() {
        int nVertices = sc.nextInt();
        int nEdges = sc.nextInt();

        Vertex[] vertices = new Vertex[nVertices + 1];
        for (int i = 1; i < vertices.length; ++i) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < nEdges; ++i) {
            // Đọc đồ thị
            int a = sc.nextInt();
            int b = sc.nextInt();

            // Đồ thị vô hướng nên a kề b, b kề a
            vertices[a].addAdjecentVertex(vertices[b]);
            vertices[b].addAdjecentVertex(vertices[a]);

        }
        return vertices;
    }

    static class Vertex {
        int id;
        List<Vertex> adjencentVertices = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addAdjecentVertex(Vertex vertex) {
            adjencentVertices.add(vertex);
        }

        public void addNeighbor(Vertex v) {
            adjencentVertices.add(v);
        }

        public int getDegree() {
            return adjencentVertices.size();
        }

        @Override
        public String toString() {
            return id + " ";
        }

    }

    // Input Reader
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
