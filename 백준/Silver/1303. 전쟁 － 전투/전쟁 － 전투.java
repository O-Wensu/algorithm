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
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 1;

    static void dfs(Node node, char team) {
        int x = node.x;
        int y = node.y;

        if (!checkRange(x, y)) return;

        if (!isVisited[x][y]) {
            isVisited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!checkRange(nx, ny)) continue;
                if (isVisited[nx][ny] || map[nx][ny] != team) continue;
                dfs(new Node(nx, ny), team);
                count++;
            }
        }
    }

    static boolean checkRange(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return false;
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        map = new char[m][n];
        isVisited = new boolean[m][n];
        List<Node> whites = new LinkedList<>();
        List<Node> blues = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = chars[j];
                if (map[i][j] == 'W') whites.add(new Node(i, j));
                else blues.add(new Node(i, j));
            }
        }

        int sumW = 0;
        //W 병사 위력
        for (Node white : whites) {
            if (!isVisited[white.x][white.y]){
                count = 1;
                dfs(white, 'W');
                sumW += (int) Math.pow(count, 2);
            }
        }

        int sumB = 0;
        //B 병사 위력
        for (Node blue : blues) {
            if (!isVisited[blue.x][blue.y]){
                count = 1;
                dfs(blue, 'B');
                sumB += (int) Math.pow(count, 2);
            }
        }

        System.out.println(sumW + " " + sumB);
    }
}