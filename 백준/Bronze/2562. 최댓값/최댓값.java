import java.io.*;

public class Main {
    static final int SIZE = 9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < SIZE; i++) {
            max = Math.max(max, arr[i]);
        }
        bw.write(max + "\n");

        for (int i = 0; i < SIZE; i++) {
            if (max == arr[i]) {
                bw.write(i + 1 + "");
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}