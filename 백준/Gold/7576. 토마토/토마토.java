import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    static int n, m;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Node> q = new LinkedList<>();
    static int bfs() {
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (graph[nx][ny] != 0) continue;
                graph[nx][ny] = graph[x][y] + 1;
                q.offer(new Node(nx, ny));
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) return -1;
                result = Math.max(result, graph[i][j]);
            }
        }
        return result - 1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(tk.nextToken());
        n = Integer.parseInt(tk.nextToken());
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(tk.nextToken());
                graph[i][j] = a;
                if (a == 1) q.offer(new Node(i, j));
            }
        }
        System.out.println(bfs());
    }
}