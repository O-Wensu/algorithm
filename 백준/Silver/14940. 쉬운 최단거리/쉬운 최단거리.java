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
    static int[][] map;
    static int[][] result;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        isVisited[x][y] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(map[nx][ny] == 0 || isVisited[nx][ny]) continue;
                isVisited[nx][ny] = true;
                result[nx][ny] = result[x][y] + 1;
                queue.offer(new Node(nx, ny));
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken()); //행
        m = Integer.parseInt(tk.nextToken()); //열
        map = new int[n][m];
        result = new int[n][m];
        isVisited = new boolean[n][m];

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        bfs(x,y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && map[i][j] == 1) {
                    bw.write(-1 + " ");
                } else {
                    bw.write(result[i][j] + " ");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}