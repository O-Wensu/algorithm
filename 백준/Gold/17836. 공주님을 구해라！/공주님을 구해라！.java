import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int x;
        int y;
        int time;
        boolean hasSword;

        public Node(int x, int y, int time, boolean hasSword) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.hasSword = hasSword;
        }
    }

    static int n, m, t;
    static int[][] map;
    static boolean[][][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0, false));
        isVisited[x][y][0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.x;
            y = node.y;

            if (node.time > t) continue;
            if (x == n - 1 && y == m - 1) return node.time;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (node.hasSword) {
                    if (!isVisited[nx][ny][1]) {
                        q.offer(new Node(nx, ny, node.time + 1, node.hasSword));
                        isVisited[nx][ny][1] = true;
                    }
                } else {
                    if (!isVisited[nx][ny][0] && map[nx][ny] == 0) {
                        q.offer(new Node(nx, ny, node.time + 1, node.hasSword));
                        isVisited[nx][ny][0] = true;
                    } else if (!isVisited[nx][ny][0] && map[nx][ny] == 2) {
                        q.offer(new Node(nx, ny, node.time + 1, true));
                        isVisited[nx][ny][0] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        t = Integer.parseInt(tk.nextToken());
        map = new int[n][m];
        isVisited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        int result = bfs(0, 0);
        if (result == -1) {
            System.out.println("Fail");
            return;
        }
        System.out.println(result);
    }
}