package LAB3;

import java.io.*;
import java.util.*;

public class EIFBF2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static List<Vertex> LiveList;
    static int nam;
    static int nu;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        Vertex[] vertices = new Vertex[n + 1];
        for (int i = 1; i <= n; i++) {
            String gender = sc.next();
            if (gender.equals("Nam")) {
                vertices[i] = new Vertex(i, true);
            } else {
                vertices[i] = new Vertex(i, false);
            }
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertices[u].addNeighbor(vertices[v]);
            vertices[v].addNeighbor(vertices[u]);
        }

        for (int i = 1; i <= n; i++) {
            if (!vertices[i].visited) {
                LiveList = new ArrayList<>();
                nam = 0;
                nu = 0;
                dfs(vertices[i]);
                for (Vertex lisVertex : LiveList) {
                    lisVertex.male = nam;
                    lisVertex.female = nu;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(vertices[i]).append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(Vertex v) {
        v.visited = true;
        LiveList.add(v);
        if (v.gender) {
            nam++;
        } else {
            nu++;
        }
        for (Vertex x : v.adj) {
            if (!x.visited) {
                dfs(x);
            }
        }
    }

    static class Vertex {
        int id;
        boolean visited;
        boolean gender;
        int male;
        int female;
        List<Vertex> adj = new ArrayList<>();

        public Vertex(int id, boolean gender) {
            this.id = id;
            this.gender = gender;
        }

        public void addNeighbor(Vertex v) {
            adj.add(v);
        }

        @Override
        public String toString() {
            return id + " " + male + " " + female;
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