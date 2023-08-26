import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int min = 0;
        while (!queue.isEmpty()) {
            int vote = queue.poll();
            if (dasom <= vote) {
                min++;
                dasom++;
                queue.offer(vote - 1);
            }
        }
        System.out.println(min);
    }
}