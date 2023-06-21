import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int k = Integer.parseInt(tk.nextToken());
        Integer[] scores = new Integer[n];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(scores, Comparator.reverseOrder());

        System.out.println(scores[k - 1]);
    }
}