import java.util.*;
import java.io.*;

public class Main {
    static int walks = 0;
    static int n, m;
    static int maxD = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(tk.nextToken());
            if (v < 0) negative.add(Math.abs(v));
            else positive.add(v);

            maxD = Math.max(maxD, Math.abs(v));
        }
        Collections.sort(negative, Comparator.reverseOrder());
        Collections.sort(positive, Comparator.reverseOrder());

        moveBook(positive);
        moveBook(negative);

        System.out.println(walks);
    }

    public static void moveBook(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i % m == 0 && list.get(i) == maxD) {
                walks += list.get(i);
            } else if (i % m == 0) {
                walks += list.get(i) * 2;
            }
        }
    }
}