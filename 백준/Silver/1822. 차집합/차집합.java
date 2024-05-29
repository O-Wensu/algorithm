import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int nA, nB;
    static long[] A, B;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        nA = Integer.parseInt(tk.nextToken());
        nB = Integer.parseInt(tk.nextToken());
        A = new long[nA]; B = new long[nB];
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < nA; i++) A[i] = Long.parseLong(tk.nextToken());
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) B[i] = Long.parseLong(tk.nextToken());
    }

    static void pro() {
        Arrays.sort(A);
        Arrays.sort(B);
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < nA; i++) {
            int L = 0, R = nB - 1;
            boolean isDuplicated = false;
            while(L <= R) {
                int mid = (L + R) / 2;
                if (B[mid] > A[i]) {
                    R = mid - 1;
                }
                else if (B[mid] < A[i]) {
                    L = mid + 1;
                }
                else {
                    isDuplicated = true;
                    break;
                }
            }
            if (!isDuplicated) list.add(A[i]);
        }
        sb.append(list.size()).append('\n');
        for (long a : list) sb.append(a).append(' ');
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}