import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        LinkedList<Integer> dq = new LinkedList<>();
        int[] selects = new int[m];
        int count = 0;

        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            selects[i] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 0; i < m; i++) {
            if (dq.getFirst() == selects[i]) {
                dq.pollFirst();
                continue;
            }
            int targetIdx = dq.indexOf(selects[i]);
            int left = targetIdx;
            int right = dq.size() - targetIdx;

            if (left <= right) {
                count += left;
                for (int j = 0; j < left; j++) {
                    dq.offerLast(dq.pollFirst());
                }
            } else {
                count += right;
                for (int j = 0; j < right; j++) {
                    dq.offerFirst(dq.pollLast());
                }
            }
            dq.pollFirst();
        }
        System.out.println(count);
    }
}