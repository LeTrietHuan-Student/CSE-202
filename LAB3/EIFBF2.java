package LAB3;

import java.util.*;
import java.io.*;
import javax.security.sasl.SaslException;

public class EIFBF2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Vertex, String> sex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            sex.put(i, sc.next());
        }
    }

    static class Vertex {
        String id;
        boolean visited;
        List<Vertex> adj = new ArrayList<>();

        public Vertex(String id, boolean visited) {
            this.id = id;
            this.visited = visited;
        }

        public void addNeighbor(Vertex v) {
            adj.add(v);
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