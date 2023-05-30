import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] graph;
    static boolean[] isVisited;
    static boolean dfs(int node) {
        if (!isVisited[node]) {
            isVisited[node] = true;

            for (int i = 1; i < n + 1; i++) {
                if (graph[node][i] == 1 && !isVisited[i]) {
                    dfs(i);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        graph = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!isVisited[i]) {
                if(dfs(i)) count++;
            }
        }
        System.out.println(count);
    }
}