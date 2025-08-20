package LAB4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class EIUOVerflow {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i, sc.nextDouble());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[v].addLink(vertexs[u]);
        }
        bfs(vertexs[0]);
        for (var ver : vertexs) {
            if (ver.list.isEmpty()) {
                sb.append(ver.id).append(" ").append(ver.contain).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void bfs(Vertex v) {
        v.check = true;
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            Vertex ver = queue.poll();
            double amount = ver.contain / Math.max(ver.list.size(), 1);
            for (var ve : ver.list) {
                if (!ve.check) {
                    ve.check = true;
                    ve.contain += amount;
                    queue.add(ve);
                }
            }
        }
    }

    static class Vertex {
        int id;
        boolean check = false;
        double contain;
        List<Vertex> list = new ArrayList<>();

        public Vertex(int id, double contain) {
            this.id = id;
            this.contain = contain;
        }

        public void addLink(Vertex v) {
            list.add(v);
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
