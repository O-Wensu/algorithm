import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] graph;
    static List<Node> areas = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    // 벽3개를 세우는 경우 구하기
    static void search(int depth, int start) {
        if (depth == 3) {
            bfs();
            return;
        }
        for (int i = start; i < areas.size(); i++) {
            Node temp = areas.get(i);
            graph[temp.x][temp.y] = 1;
            search(depth + 1, i + 1);
            graph[temp.x][temp.y] = 0;
        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        // 바이러스 위치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }

        int virusGraph[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            virusGraph[i] = graph[i].clone();
        }

        // 전염시키기
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (virusGraph[nx][ny] == 0) {
                    queue.offer(new Node(nx, ny));
                    virusGraph[nx][ny] = 2;
                }
            }
        }

        //안전 영역 개수 세기
        countSafeArea(virusGraph);
    }

    static void countSafeArea(int[][] virusGraph) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusGraph[i][j] == 0) count++;
            }
        }
        max = Math.max(max, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(tk.nextToken());
                if (graph[i][j] == 0) {
                    areas.add(new Node(i, j));
                }
            }
        }

        search(0, 0);
        System.out.println(max);
    }
}