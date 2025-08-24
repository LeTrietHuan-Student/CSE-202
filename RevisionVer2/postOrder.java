package RevisionVer2;

import java.io.*;
import java.util.*;

public class postOrder {
    static int index = 0;
    static int[] preOrder;
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Integer> inOrder = new HashMap<>();

    public static void main(String[] args) {
        int n = sc.nextInt();
        preOrder = new int[n];
        for (int i = 0; i < n; i++) {
            preOrder[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            inOrder.put(sc.nextInt(), i);
        }
        PrintPost(0, n);
        System.out.println(sb);

    }

    static void PrintPost(int start, int end) {
        if (start >= end)
            return;
        int node = preOrder[index++];
        int mid = inOrder.get(node);
        PrintPost(start, mid);
        PrintPost(mid + 1, end);
        sb.append(node).append(" ");

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
