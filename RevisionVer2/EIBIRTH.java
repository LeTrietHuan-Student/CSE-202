package RevisionVer2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EIBIRTH {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            int bithday = sc.nextInt();
            vertexs[i] = new Vertex(i, bithday);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
        }

        for (var e : vertexs) {
            int count = 0;
            for (var ve : e.list) {
                if (k + d > 365) {
                    if (ve.birthday <= (k + d) % 365 || ve.birthday >= (k + d) % 365)
                        count++;
                    else {
                        if (ve.birthday <= (k + d) % 365 && ve.birthday >= (k + d) % 365)
                            count++;
                    }
                }
            }
            sb.append(count).append(" ");

        }
        System.out.println(sb);

    }

    static class Vertex {

        int id;
        int birthday;
        ArrayList<Vertex> list = new ArrayList<>();

        public Vertex(int id, int birthday) {
            this.id = id;
            this.birthday = birthday;
        }

        public void addLink(Vertex v) {
            list.add(v);
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
