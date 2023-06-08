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

    static int n;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;
    static int max = 1;

    static void checkSink(int height) {
        isVisited = new boolean[n][n];
        int[][] copyMap = new int[n][n];
        count = 0;
        for (int i = 0; i < n; i++) {
            copyMap[i] = map[i];
        }

        List<Node> notSink = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copyMap[i][j] <= height) copyMap[i][j] = 0; //잠김 표시
                else notSink.add(new Node(i, j));
            }
        }

        for (Node node : notSink) {
            if (!isVisited[node.x][node.y]) {
                if (dfs(copyMap, node)) count++;
            }
        }
        max = Math.max(max, count);
    }

    static boolean dfs(int[][] map, Node node) {
        int x = node.x;
        int y = node.y;
        if (!checkRange(x, y)) return false;

        if (!isVisited[x][y] && map[x][y] != 0) {
            isVisited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!checkRange(nx, ny)) continue;
                if (map[nx][ny] == 0) continue;
                dfs(map, new Node(nx, ny));
            }
            return true;
        }
        return false;
    }

    static boolean checkRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> heights = new HashSet<>();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
                heights.add(map[i][j]);
            }
        }

        for (Integer height : heights) {
            checkSink(height);
        }
        System.out.println(max);
    }

}