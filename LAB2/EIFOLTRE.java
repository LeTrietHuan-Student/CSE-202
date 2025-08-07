package LAB2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class EIFOLTRE {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        HashMap<String, Vertex> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String u = sc.next();
            String v = sc.next();
            if (!map.containsKey(u)) {
                map.put(u, new Vertex(u));
            }
            if (!map.containsKey(v)) {
                map.put(v, new Vertex(v));
            }
            map.get(u).addLink(map.get(v));
            map.get(v).addLink(map.get(u));
        }
        for (var item : map.values()) {
            item.list.sort((s1, s2) -> {
                return s1.id.compareToIgnoreCase(s2.id);
            });
        }
        dfs(map.get(sc.next()), "-");
        System.out.println(sb);
    }

    static void dfs(Vertex v, String space) {
        v.check = true;
        sb.append(space).append(v.id).append("\n");
        for (var ver : v.list) {
            if (!ver.check) {
                dfs(ver, space + "---");
            }
        }
    }

    static class Vertex {

        String id;
        boolean check;
        List<Vertex> list = new ArrayList<>();

        public Vertex(String id) {
            this.id = id;
            this.check = false;
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
