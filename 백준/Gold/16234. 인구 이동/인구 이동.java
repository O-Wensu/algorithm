import java.util.*;
import java.io.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};
    static boolean isNone = true;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        List<Node> unions = new ArrayList<>();
        q.offer(node);
        unions.add(node);

        while(!q.isEmpty()) {
            node = q.poll();
            int x = node.x;
            int y = node.y;
            isVisited[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (isVisited[nx][ny]) continue;

                //연합이 가능하면
                if (L <= Math.abs(map[x][y] - map[nx][ny])
                        && Math.abs(map[x][y] - map[nx][ny]) <= R) {
                    Node temp = new Node(nx, ny);
                    unions.add(temp);
                    isVisited[nx][ny] = true;
                    q.offer(temp);
                }
            }
        }

        //2개 이상 연합이 아니면
        if (unions.size() >= 2) {
            isNone = false;
        } else {
            return;
        }

        int count = unions.size();
        int people = 0;
        for (Node union : unions) {
            people += map[union.x][union.y];
        }
        int divide = people / count;

        for (Node union : unions) {
            map[union.x][union.y] = divide;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        L = Integer.parseInt(tk.nextToken());
        R = Integer.parseInt(tk.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        int day = 0;
        while(true) {
            isVisited = new boolean[N][N];
            isNone = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!isVisited[i][j]) {
                        bfs(new Node(i, j));
                    }
                }
            }
            if (isNone) break;
            day++;
        }
        System.out.println(day);
    }
}