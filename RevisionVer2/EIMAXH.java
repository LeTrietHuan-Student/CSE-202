package RevisionVer2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EIMAXH {
    static int max;
    static int minIndex;

    public static void main(String[] args) {
        int n = sc.nextInt();
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertices[u].addLink(vertices[v]);
            vertices[v].addLink(vertices[u]);
        }
        int min1 = dfs(vertices[0]);
        for (var ve : vertices) {
            ve.visited = false;
            ve.level = 0;
        }
        int min2 = dfs(vertices[min1]);
        System.out.println(Math.min(min1, min2) + " " + max);
    }

    static int dfs(Vertex v) {
        v.visited = true;
        if (v.level > max) {
            max = v.level;
            minIndex = v.id;
        }
        if (v.level == max) {
            minIndex = Math.min(minIndex, v.id);
        }
        for (var e : v.list) {
            if (!e.visited) {
                e.level = v.level + 1;
                dfs(e);
            }
        }
        return minIndex;

    }

    static class Vertex {
        int id;
        int level = 0;
        boolean visited = false;
        List<Vertex> list = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addLink(Vertex v) {
            list.add(v);
        }
    }

    static InputReader sc = new InputReader(System.in);

    static class InputReader {

        StringTokenizer tokenizer;
        BufferedReader reader;
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
