import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        Integer[] trees = new Integer[n];
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(trees, Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            days[i] = i + 1 + trees[i];
        }
        int max = Arrays.stream(Arrays.stream(days).toArray()).max().getAsInt();
        System.out.println(max + 1);
    }
}