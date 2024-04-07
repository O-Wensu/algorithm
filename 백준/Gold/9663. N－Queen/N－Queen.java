import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, ans;
    static int[] col; //col[i]: i번 행의 퀸은 col[i]번 열에 놓았다는 기록

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N + 1];
    }

    static boolean attakable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true; 
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }

    static void rec_func(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int cand = 1; cand <= N; cand++) {
                boolean possible = true;
                for (int i = 1; i <= row - 1; i++) {
                    if (attakable(row, cand, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = cand;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        System.out.println(ans);
    }
}