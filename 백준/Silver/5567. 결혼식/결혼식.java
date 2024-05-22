import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] A;
    static int[] dist;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) A[i] = new ArrayList<>();
        StringTokenizer tk;
        for (int i = 1; i <= M; i++) {
            tk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tk.nextToken());
            int y = Integer.parseInt(tk.nextToken());
            A[x].add(y);
            A[y].add(x);
        }
    }

    static int bfs(int x) {
        int cnt = 0; // 초대 가능한 사람 수
        for (int i = 0; i <= N; i++) dist[i] = -1;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(x);
        dist[x] = 0;

        while(!Q.isEmpty()) {
            x = Q.poll();
            if (1 <= dist[x] && dist[x] <= 2) cnt++;
            if (dist[x] == 2) continue;
            for (int y : A[x]) {
                if (dist[y] != -1) continue;
                Q.add(y);
                dist[y] = dist[x] + 1;
            }
        }
        return cnt;
    }

    static void pro() {
        dist = new int[N + 1];
        System.out.println(bfs(1));
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}