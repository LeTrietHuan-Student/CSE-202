package LAB5;

import java.io.*;
import java.util.*;

public class EIMAXHTR {

    static int max = 0;
    static int minIndex;

    public static void main(String[] args) {
        int n = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
        }
        int min1 = dfs(vertexs[0]);
        for (var ver : vertexs) {
            ver.check = false;
            ver.level = 0;
        }
        int min2 = dfs(vertexs[min1]);
        System.out.println(Math.min(min1, min2) + " " + max);
    }

    static int dfs(Vertex v) {
        v.check = true;
        if (v.level > max) {
            max = v.level;
            minIndex = v.id;
        } else if (v.level == max)
            minIndex = Math.min(minIndex, v.id);

        for (var ver : v.list) {
            if (!ver.check) {
                ver.level = v.level + 1;
                dfs(ver);
            }
        }
        return minIndex;
    }

    static class Vertex {
        int id;
        int level = 0;
        boolean check = false;
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
