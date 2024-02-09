import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int emptyRow = 0;
        int emptyCol = 0;
        char[][] map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            if (!row.contains("X")) {
                emptyRow++;
            }
            map[i] = row.toCharArray();
        }
        for (int i = 0; i < M; i++) {
            boolean isEmpty = true;
            for (int j = 0; j < N; j++) {
                if (map[j][i] == 'X') {
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) emptyCol++;
        }
        System.out.println(Math.max(emptyRow, emptyCol));
    }
}