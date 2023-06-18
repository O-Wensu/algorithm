import java.util.*;
import java.io.*;

public class Main {

    static int n, k;
    static int[] dx = {-1, 1};
    static int[] time = new int[1000001];
    static int minTime = Integer.MAX_VALUE;
    static int count = 0;

    static void bfs(int x) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        time[x] = 1;

        while (!queue.isEmpty()) {
            x = queue.poll();

            if (minTime < time[x]) return;

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 2) nx = 2 * x;
                else nx = x + dx[i];

                if (nx < 0 || nx >= time.length) continue;

                if (nx == k) {
                    minTime = time[x];
                    count++;
                }

                if (time[nx] == 0 || time[nx] == time[x] + 1) {
                    time[nx] = time[x] + 1;
                    queue.offer(nx);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        k = Integer.parseInt(tk.nextToken());

        if (n == k) {
            System.out.println("0 1");
            return;
        }

        bfs(n);
        System.out.println(minTime);
        System.out.println(count);
    }
}