import java.io.*;
import java.util.*;

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

    public static int bfs(int x, int y) {
        q.offer(new Node(x, y));
        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (graph[nx][ny] != 1) continue;
                graph[nx][ny] = graph[x][y] + 1;
                q.offer(new Node(nx, ny));
            }
        }
        return graph[n-1][m-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        graph = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                graph[i][j] = chars[j] - '0';
            }
        }
        int result = bfs(0,0);
        System.out.println(result);
    }
}