import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void dfs(int x) {
        visited[x] = true;
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) dfs(y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        visited = new boolean[size + 1];

        for (int i = 0; i < size + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < num; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }   
        dfs(1);
        int count = 0;
        for (boolean b : visited) {
            if (!b) count++;
        }
        System.out.println(size - count);
    }
}