import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 100000;
    static int N, K;
    static boolean[] visit;
    static int[] dist;

     static void input() throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer tk = new StringTokenizer(br.readLine());
         N = Integer.parseInt(tk.nextToken());
         K = Integer.parseInt(tk.nextToken());
         visit = new boolean[MAX + 1];
         dist = new int[MAX + 1];
     }

     static void bfs() {
         Queue<Integer> Q = new LinkedList<>();
         Q.offer(N);
         visit[N] = true;

         while(!Q.isEmpty()) {
             int x = Q.poll();
             int y = x - 1;
             if (y >= 0 && y <= MAX && !visit[y]){
                 visit[y] = true;
                 dist[y] = dist[x] + 1;
                 Q.add(y);
             }

             y = x + 1;
             if (y >= 0 && y <= MAX && !visit[y]){
                 visit[y] = true;
                 dist[y] = dist[x] + 1;
                 Q.add(y);
             }

             y = x * 2;
             if (y >= 0 && y <= MAX && !visit[y]){
                 visit[y] = true;
                 dist[y] = dist[x] + 1;
                 Q.add(y);
             }
         }
     }

     static void pro() {
         bfs();
         System.out.println(dist[K]);
     }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}