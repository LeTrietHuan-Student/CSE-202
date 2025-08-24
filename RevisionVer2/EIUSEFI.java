package RevisionVer2;

import java.io.*;
import java.util.*;

public class EIUSEFI {
    static String k;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        HashMap<String, Vertex> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String u = sc.next();
            String v = sc.next();
            map.putIfAbsent(u, new Vertex(u));
            map.putIfAbsent(v, new Vertex(v));
            map.get(u).addLink(map.get(v));
            map.get(v).addLink(map.get(u));
        }
        String root = sc.next();
        String k = sc.next();

        for (var e : map.values()) {
            e.list.sort((s1, s2) -> {
                return s1.id.compareTo(s2.id);
            });
        }
        for (var e : map.values()) {
            if (e.list.size() > 1) {
                e.isRoot = true;
            }
        }
        dfs(map.get(root));
        System.out.println(sb);

    }

    static void dfs(Vertex v) {
        v.check = true;
        for (var ver : v.list) {
            if (!ver.check) {
                dfs(ver);
                if (ver.id.toLowerCase().contains(k.toLowerCase()) && !ver.isRoot) {
                    v.count += 1;
                }
                if (ver.isRoot) {
                    v.count += ver.count;
                }
            }
        }
        if (v.count != 0) {
            sb.append(v.id).append(" ").append(v.count).append("\n");
        }
    }

    static class Vertex {
        String id;
        boolean check = false;
        int count = 0;
        boolean isRoot; // Important
        List<Vertex> list = new ArrayList<>();

        public Vertex(String id) {
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
