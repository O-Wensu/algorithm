import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        boolean[] existRow = new boolean[N];
        boolean[] existCol = new boolean[M];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'X') {
                    existRow[i] = true;
                    existCol[j] = true;
                }
            }
        }
        int emptyRow = N;
        int emptyCol = M;
        for (int i = 0; i< N; i++) {
            if (existRow[i]) emptyRow--;
        }
        for (int i = 0; i< M; i++) {
            if (existCol[i]) emptyCol--;
        }
        System.out.println(Math.max(emptyRow, emptyCol));
    }
}