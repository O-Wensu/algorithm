import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int x;
        int y;
        int isBroken;
        int count;

        public Node(int x, int y, int isBroken, int count) {
            this.x = x;
            this.y = y;
            this.isBroken = isBroken;
            this.count = count;
        }
    }

    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][][] isVisited;
    static int min = Integer.MAX_VALUE;

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0, 1));
        isVisited[x][y][0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.x;
            y = node.y;
            int isBroken = node.isBroken;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (isVisited[nx][ny][isBroken]) continue;
                if (nx == n - 1 && ny == m - 1) {
                    isVisited[nx][ny][isBroken] = true;
                    min = Math.min(min, node.count + 1);
                    continue;
                }

                //지금껏 부순 벽이 없고 && 벽을 마주쳤다면 부수기
                if (isBroken == 0 && map[nx][ny] == 1) {
                    isVisited[nx][ny][1] = true;
                    q.offer(new Node(nx, ny, 1, node.count + 1));
                } else if (map[nx][ny] == 0) { //지금껏 부순 벽이 있든 없든, 갈 수 있는 곳 길이면 이동
                    isVisited[nx][ny][isBroken] = true;
                    q.offer(new Node(nx, ny, isBroken, node.count + 1));
                } else if (isBroken == 1 && map[nx][ny] == 1) {
                    continue;
                }
            }
        }
        if (!isVisited[n - 1][m - 1][0] && !isVisited[n - 1][m - 1][1]) {
            System.out.println("-1");
        } else {
            System.out.println(min);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        map = new int[n][m];
        isVisited = new boolean[n][m][2]; //0: 부서진 벽이 없는 경우, 1: 부서진 벽이 있는 경우

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        if (n == 1 && m == 1) System.out.println(1);
        else bfs(0, 0);
    }
}