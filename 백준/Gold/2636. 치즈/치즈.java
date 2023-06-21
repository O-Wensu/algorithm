import javax.swing.text.html.ListView;
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

    static int n, k;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] isAir;
    static List<Node> removePos = new ArrayList<>();

    static void searchAir(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        isAir[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            x = node.x;
            y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!checkRange(nx, ny)) continue;

                if (map[nx][ny] == 0 && !isAir[nx][ny]) {
                    isAir[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    static void searchCheese(int x, int y) {
        if (!checkRange(x, y)) return;

        if (map[x][y] == 1) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!checkRange(nx, ny)) continue;

                //외부에 노출된 치즈이면
                if (map[nx][ny] == 0 && isAir[nx][ny]) {
                    removePos.add(new Node(x, y));
                    return;
                }
            }
        }
    }

    static boolean checkRange(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= k) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        k = Integer.parseInt(tk.nextToken());
        map = new int[n][k];
        isAir = new boolean[n][k];
        int remainCheese = 0;
        int hour = 0;

        for (int i = 0; i < n; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
                if (map[i][j] == 1) remainCheese++;
            }
        }

        while (true) {
            // hole과 공기 구분
            isAir = new boolean[n][k];
            searchAir(0, 0);

            //녹는 치즈 찾기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < k; j++) {
                    if (map[i][j] == 1){
                        searchCheese(i, j);
                    }
                }
            }
            hour++;

            //녹은 치즈 0으로 변경
            for (Node pos : removePos) {
                map[pos.x][pos.y] = 0;
            }

            //아직 남은 치즈가 있다면 치즈 수 갱신
            if (remainCheese - removePos.size() > 0) {
                remainCheese -= removePos.size();
            } else {
                break;
            }
            removePos.clear();
        }
        System.out.println(hour);
        System.out.println(remainCheese);
    }
}