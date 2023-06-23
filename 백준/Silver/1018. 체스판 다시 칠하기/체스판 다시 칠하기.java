import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static char[][] map;
    static int min = Integer.MAX_VALUE;

    static void paint(int x, int y) {
        if (x + 7 >= n || y + 7 >= m) return;
        int count = 0;
        char color = map[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (map[i][j] != color) {
                    count++;
                }
                color = color == 'W' ? 'B' : 'W';
            }
            color = color == 'W' ? 'B' : 'W';
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = chars[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paint(i, j);
            }
        }

        System.out.println(min);
    }
}