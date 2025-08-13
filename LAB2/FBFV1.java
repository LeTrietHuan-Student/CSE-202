package LAB2;

import java.io.*;
import java.util.*;

public class FBFV1 {
    static InputReader sc;
    static StringBuilder sb = new StringBuilder();
    static int maxIndex = 0;
    static int males, females;

    public static void main(String[] args) throws IOException {
        sc = new InputReader(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] vertexs = new Vertex[n + 1];

        for (int i = 1; i <= n; i++) {
            String gender = sc.next();
            if (gender.equals("Nam")) {
                vertexs[i] = new Vertex(i, true);
            } else {
                vertexs[i] = new Vertex(i, false);
            }
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addNeighbor(vertexs[v]);
            vertexs[v].addNeighbor(vertexs[u]);
        }
        List<Connectivty> myConnectivties = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!vertexs[i].visited) {

                maxIndex = 0;
                males = 0;
                females = 0;
                dfs(vertexs[i]);
                myConnectivties.add(new Connectivty(maxIndex, males, females));
            }
        }
        myConnectivties.sort((s1, s2) -> {
            return Integer.compare(s1.id, s2.id);
        });
        for (Connectivty connectivty : myConnectivties) {
            sb.append(connectivty).append("\n");
        }
        System.out.println(sb);
    }

    static class Connectivty {
        int id;
        int males;
        int females;

        public Connectivty(int id, int males, int females) {
            this.id = id;
            this.males = males;
            this.females = females;
        }

        @Override
        public String toString() {
            return id + " " + males + " " + females;
        }

    }

    static void dfs(Vertex v) {
        v.visited = true;
        maxIndex = Math.max(maxIndex, v.id);
        if (v.gender) {
            males++;
        } else {
            females++;
        }

        for (Vertex w : v.adjacentVertices) {
            if (!w.visited) {
                dfs(w);
            }
        }
    }

    static class Vertex {
        int id;

        boolean gender;
        boolean visited;

        List<Vertex> adjacentVertices = new ArrayList<>();

        public Vertex(int id, boolean gender) {
            this.id = id;
            this.gender = gender;

        }

        public void addNeighbor(Vertex v) {
            adjacentVertices.add(v);
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
