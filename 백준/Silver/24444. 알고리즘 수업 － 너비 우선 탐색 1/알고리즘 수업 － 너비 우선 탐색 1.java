import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] map;
    static int[] sequence;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int r = Integer.parseInt(tk.nextToken());
        map = new ArrayList[n + 1];
        sequence = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());
            map[u].add(v);
            map[v].add(u);
        }
        //오름차순 정렬
        for (int i = 1; i < n + 1; i++) {
            Collections.sort(map[i]);
        }
        bfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < sequence.length; i++) {
            sb.append(sequence[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        int seq = 1;
        sequence[node] = seq;

        while(!q.isEmpty()) {
            node = q.poll();

            for (int i = 0; i < map[node].size(); i++) {
                int next = map[node].get(i);
                if (sequence[next] == 0) {
                    seq++;
                    sequence[next] = seq;
                    q.offer(next);
                }
            }
        }
    }
}