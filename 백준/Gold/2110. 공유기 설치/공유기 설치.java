import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int c = Integer.parseInt(tk.nextToken());
        int[] pos = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pos[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(pos);

        int start = 1;
        int end = pos[n] - pos[1];
        int result = 0;

        while (start <= end) {
            int distance = (start + end) / 2;
            int count = 1;
            int prevInstall = pos[1];
            for (int i = 2; i <= n; i++) {
                int gap = pos[i] - prevInstall;
                if (gap >= distance) {
                    count++;
                    prevInstall = pos[i]; 
                }
            }

            if (count < c) { 
                end = distance - 1;
            } else { 
                result = distance;
                start = distance + 1;
            }
        }
        System.out.println(result);
    }
}