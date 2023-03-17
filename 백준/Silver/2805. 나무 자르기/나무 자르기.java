import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int[] trees = new int[n];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(tk.nextToken());
        }
        int start = 0;
        int end = Arrays.stream(trees).max().getAsInt();

        int result = 0;
        while(start <= end) {
            long total = 0;
            int mid = (start + end) / 2;

            for (int tree : trees) {
                if (tree > mid ) {
                    total += tree - mid;
                }
            }

            if (total < m) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}