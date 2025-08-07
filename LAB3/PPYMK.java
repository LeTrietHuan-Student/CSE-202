package LAB3;

import java.io.*;
import java.util.*;

public class PPYMK {
    static InputReader sc;
    static Map<Integer, TreeSet<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        sc = new InputReader(System.in);

        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();

        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i);
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].add(vertexs[v]);
            vertexs[v].add(vertexs[u]);
        }

        int startVertex = sc.nextInt();
        int q = sc.nextInt();
        int[] queries = new int[q];
        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextInt();
        }
        bfs(vertexs[startVertex], vertexs);
        for (int k : queries) {
            TreeSet<Integer> mIntegers = map.get(k);

            if (mIntegers == null) {
                sb.append("-1");
            } else {
                for (int i : mIntegers) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void bfs(Vertex startVertex, Vertex[] vertexs) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startVertex);
        startVertex.level = 0;
        startVertex.visited = true;

        while (!queue.isEmpty()) {
            Vertex w = queue.poll();

            for (Vertex u : w.adj) {
                if (!u.visited) {
                    queue.add(u);
                    u.visited = true;
                    u.level += w.level + 1;
                    if (!map.containsKey(w.level + 1)) {
                        TreeSet<Integer> mySet = new TreeSet<>();
                        map.put(w.level + 1, mySet);
                    }
                    TreeSet<Integer> myTreeSet = map.get(w.level + 1);
                    myTreeSet.add(u.id);

                }
            }
        }
    }

    static class Vertex {
        int id;
        boolean visited;
        int level;
        List<Vertex> adj = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void add(Vertex v) {
            adj.add(v);
        }

    }

    static class InputReader {
        private byte[] inbuf = new byte[2 << 23];
        public int lenbuf = 0, ptrbuf = 0;
        public InputStream is;

        public InputReader(InputStream stream) throws IOException {

            inbuf = new byte[2 << 23];
            lenbuf = 0;
            ptrbuf = 0;
            is = System.in;
            lenbuf = is.read(inbuf);
        }

        public InputReader(FileInputStream stream) throws IOException {
            inbuf = new byte[2 << 23];
            lenbuf = 0;
            ptrbuf = 0;
            is = stream;
            lenbuf = is.read(inbuf);
        }

        public boolean hasNext() throws IOException {
            if (skip() >= 0) {
                ptrbuf--;
                return true;
            }
            return false;
        }

        public String nextLine() throws IOException {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b) && b != ' ') { // when nextLine, ()
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b
                                        // != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        private int readByte() {
            if (lenbuf == -1)
                throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0)
                    return -1;
            }
            return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        public Character nextChar() {
            return skip() >= 0 ? (char) skip() : null;
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b))
                ;
            return b;
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }

}
