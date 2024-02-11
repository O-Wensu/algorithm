import java.util.*;
import java.io.*;

public class Main {
    public static int[] insert(int[] arr, int targetIndex, int currentIndex, int n) {
        for (int i = currentIndex; i > targetIndex; i--) {
            arr[i] = arr[i - 1];
        }
        arr[targetIndex] = n;
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int P = Integer.parseInt(br.readLine());
        int SIZE = 20;
        for (int i = 0; i < P; i++) {
            int[] heights = new int[SIZE];
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(tk.nextToken());
            int totalCount = 0;
            for (int j = 0; j < SIZE; j++) {
                heights[j] = Integer.parseInt(tk.nextToken());
            }

            for (int j = 1; j < SIZE; j++) {
                int count = 0;
                int current = heights[j];
                int index = j - 1;
                while(index >= 0 && current < heights[index]) {
                    count++;
                    index--;
                }
                if (count > 0) heights = insert(heights, j - count, j, current);
                totalCount += count;
            }
            bw.write(T + " " + totalCount + "\n");
        }
        bw.flush();
    }
}