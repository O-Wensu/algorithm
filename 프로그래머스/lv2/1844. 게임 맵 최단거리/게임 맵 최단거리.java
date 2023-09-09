import java.util.*;
class Solution {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int row = maps.length; //행
        int col = maps[0].length; //열

        if (maps[row - 1][col - 1] == 0) return -1;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == row - 1 && node.y == col - 1) {
                return maps[row - 1][col - 1];
            }
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col) continue;
                if (maps[nx][ny] != 1) continue;

                maps[nx][ny] = maps[node.x][node.y] + 1;
                queue.offer(new Node(nx, ny));
            }
        }
        return -1;
    }
}