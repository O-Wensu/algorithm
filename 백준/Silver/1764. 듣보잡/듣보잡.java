import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static String[] A, ans;
    
    static void input() throws IOException {
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        A = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = br.readLine();
        }
    }

    static boolean binSearch(int L, int R, String target) {
        while(L <= R) {
            int mid = (L + R) / 2;
            if (A[mid].equals(target)) return true;
            if (A[mid].compareTo(target) > 0)
                R = mid - 1;
            else
                L = mid + 1;
        }
        return false;
    }

    static void pro() throws IOException {
        int ansCnt = 0;
        ans = new String[N];
        Arrays.sort(A, 1, N + 1);
        for (int i = 1; i <= M; i++) {
            String name = br.readLine();
            if (binSearch(1, N, name)) ans[ansCnt++] = name;
        }
        Arrays.sort(ans, 0, ansCnt);
        sb.append(ansCnt).append('\n');
        for (int i = 0; i < ansCnt; i++) sb.append(ans[i]).append('\n');
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}