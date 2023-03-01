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
    static int answer = 0;
    static Queue<Node> q1 = new LinkedList<>();

    static boolean bfs() {
        Queue<Node> q2 = new LinkedList<>();
        while (!q1.isEmpty()) {
            Node node = q1.poll();
            int x = node.getX();
            int y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (graph[nx][ny] != 0) continue;
                graph[nx][ny] = 1;
                q2.offer(new Node(nx, ny));
            }
            if (q1.isEmpty()) {
                answer++;
                for (Node data : q2) {
                    q1.offer(data);
                }
                q2.clear();
            }
        }
        int zeroCnt = (int) Arrays.stream(graph)
                .flatMapToInt(Arrays::stream)
                .filter(it -> it == 0)
                .count();
        if (zeroCnt > 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(tk.nextToken()); //열
        n = Integer.parseInt(tk.nextToken()); //행
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int a = Integer.parseInt(tk.nextToken());
                graph[i][j] = a;
                if (a == 1) q1.offer(new Node(i, j));
            }
        }

        if (bfs()) {
            System.out.println(answer - 1);
        } else {
            System.out.println("-1");
        }
    }
}