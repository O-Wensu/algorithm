import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tk;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        tk = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(tk.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        tk = new StringTokenizer(br.readLine());
    }

    static boolean binary_search(int[] arr, int l, int r, int x) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) return true;

            if (arr[mid] < x)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            int x = Integer.parseInt(tk.nextToken());
            if (binary_search(A, 1, N, x)) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.print(sb);
    }
}