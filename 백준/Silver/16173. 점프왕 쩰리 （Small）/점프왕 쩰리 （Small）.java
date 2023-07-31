import java.io.*;
import java.util.*;
 
public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        N = Integer.parseInt(br.readLine());
 
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        System.out.println(dfs(board));
 
        br.close();
    }
 
    static public String dfs(int[][] board) {
        Stack<Node> stack = new Stack<>();
        boolean[][] visited = new boolean[N][N];
        stack.add(new Node(0, 0, board[0][0]));
 
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
 
            int x = cur.x;
            int y = cur.y;
            int count = cur.count;
 
            if (board[x][y] == -1) {
                return "HaruHaru";
            }
 
            if (visited[x][y]) {
                continue;
            }
 
            visited[x][y] = true;
 
            if (x + count < N && !visited[x + count][y]) {
                stack.add(new Node(x + count, y, board[x + count][y]));
            }
 
            if (y + count < N && !visited[x][y + count]) {
                stack.add(new Node(x, y + count, board[x][y + count]));
            }
        }
 
        return "Hing";
    }
}
 
class Node {
    int x;
    int y;
    int count;
 
    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}