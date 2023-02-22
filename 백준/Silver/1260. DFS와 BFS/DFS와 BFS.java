import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int[][] graph;
    public static boolean[] visited;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Queue<Integer> queue = new LinkedList<>();

    public static void dfs(int node) throws IOException {
        visited[node] = true;
        bw.write(node + " ");

        for (int i = 1; i < n + 1; i++) {
            if (graph[node][i] == 1 && !visited[i]) dfs(i);
        }
    }

    public static void bfs(int node) throws IOException {
        queue.offer(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int x = queue.poll();
            bw.write(x + " ");
            for (int i = 0; i < n + 1; i++) {
                if (graph[x][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int v = Integer.parseInt(tk.nextToken());
        visited = new boolean[n + 1];
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        dfs(v);
        visited = new boolean[n + 1];
        bw.append("\n");
        bfs(v);
        bw.flush();
        bw.close();
        br.close();
    }
}