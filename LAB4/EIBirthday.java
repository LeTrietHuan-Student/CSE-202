package LAB4;
import java.util.*;
import java.io.*;

public class EIBirthday {

static InputReader sc = new InputReader(System.in);
static StringBuilder sb = new StringBuilder();
    
public static void main(String[] args) {
    int n =sc.nextInt();
    int m =sc.nextInt();
    int d =sc.nextInt();
    int k =sc.nextInt();

    int BirthdaySpan=d+k;
    Vertex[] vertices = new Vertex[n];
    for (int i=0;i<n;i++){
        vertices[i]= new Vertex(i);
        vertices[i].birthday=sc.nextInt();
    }
    for (int i=0;i<m;i++){
        int u=sc.nextInt();
        int v=sc.nextInt();
        vertices[u].addNeighbor(vertices[v]);
        vertices[v].addNeighbor(vertices[u]);
    }
    
}
    static void bfs(Vertex startVertex, Vertex[] vertexs) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startVertex);
        startVertex.visited = true;
        while (!queue.isEmpty()) {
            Vertex w = queue.poll();

          
        }
    }

    static class Vertex{
        int id;
        int birthday;
        boolean visited;
        List<Vertex> adj = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public void addNeighbor(Vertex v){
            adj.add(v);
        }
        

    }


    // input reader
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
