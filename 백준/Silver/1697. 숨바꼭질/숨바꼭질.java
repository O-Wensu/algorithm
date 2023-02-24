import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[] visited = new int[100001];
    static int[] dx = {-1, 1};

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = 1;

        while(!q.isEmpty()) {
            x = q.poll();
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 2) {
                    nx = 2 * x;
                } else {
                    nx = x + dx[i];
                }
                if (nx == k) {
                    System.out.println(visited[x]);
                    return;
                }
                if (nx < 0 || nx >= visited.length) continue;
                if (visited[nx] == 0) {
                    visited[nx] = visited[x] + 1;
                    q.offer(nx);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        k = Integer.parseInt(tk.nextToken());

        if (n == k) System.out.println("0");
        else bfs(n);
    }
}