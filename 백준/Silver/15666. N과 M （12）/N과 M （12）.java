import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] numbers;
    static int[] arr;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void search(int depth, int start) throws IOException{
        if(depth == m) {
            for (int i : arr) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        int prev = 0;
        for (int i = start; i < n; i++) {
            if (prev != numbers[i]) {
                prev = numbers[i];
                arr[depth] = numbers[i];
                search(depth + 1, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        numbers = new int[n];
        arr = new int[m];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(numbers);

        search(0,0);
        bw.flush();
        bw.close();
        br.close();
    }
}