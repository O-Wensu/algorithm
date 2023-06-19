import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static final int MAX = 100001;
    static int[] time = new int[MAX];
    static int[] dx = {-1, 1};

    static class Node {
        int x;
        Node prev;

        public Node(int x, Node prev) {
            this.x = x;
            this.prev = prev;
        }
    }

    static void bfs(int x) {
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        Node temp = new Node(x, null);
        queue.offer(temp);
        time[x] = 1;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.x;
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 2) {
                    nx = x * 2;
                } else {
                    nx = x + dx[i];
                }

                if (nx < 0 || nx >= MAX) continue;

                if (nx == k) {
                    Deque<Integer> dq = new LinkedList<>();
                    Node nowNode = new Node(nx, node);
                    sb.append(time[x]).append("\n");
                    while(true) {
                        dq.offerFirst(nowNode.x);
                        if (nowNode.prev == null) break;
                        nowNode = nowNode.prev;
                    }
                    while(!dq.isEmpty()) {
                        sb.append(dq.pollFirst() + " ");
                    }
                    System.out.println(sb);
                    return;
                }

                if (time[nx] == 0 || time[nx] == time[x] + 1) {
                    time[nx] = time[x] + 1;
                    Node newNode = new Node(nx, node);
                    queue.offer(newNode);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        k = Integer.parseInt(tk.nextToken());

        if (n == k) {
            System.out.println(0);
            System.out.println(n);
            return;
        }
        bfs(n);
    }
}