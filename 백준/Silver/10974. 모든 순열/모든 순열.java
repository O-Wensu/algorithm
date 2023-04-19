import java.io.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static boolean[] isUsed;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void sequence(int depth) throws IOException {
        if (depth == n) {
            for (int i : arr) {
                bw.write(i+ " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[depth] = i;
                sequence(depth + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        isUsed = new boolean[n + 1];
        sequence(0);
        bw.flush();
        bw.close();
        br.close();
    }
}