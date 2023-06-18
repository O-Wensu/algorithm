import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    static int n, k;
    static boolean[] isVisited = new boolean[100001];
    static int minTime = Integer.MAX_VALUE;

    static void bfs(int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            isVisited[node.x] = true;
            if (node.x == k) minTime = Math.min(minTime, node.time);

            int next = 2 * node.x;
            if (next >= 0 && next < isVisited.length && !isVisited[next]) {
                queue.offer(new Node(next, node.time));
            }
            next = node.x + 1;
            if (next >= 0 && next < isVisited.length && !isVisited[next]) {
                queue.offer(new Node(next, node.time + 1));
            }
            next = node.x - 1;
            if (next >= 0 && next < isVisited.length && !isVisited[next]) {
                queue.offer(new Node(next, node.time + 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        k = Integer.parseInt(tk.nextToken());

        if (n == k) {
            System.out.println("0");
            return;
        }

        bfs(n);
        System.out.println(minTime);
    }
}