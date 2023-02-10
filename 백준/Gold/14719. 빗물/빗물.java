import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token1 = new StringTokenizer(br.readLine());
        StringTokenizer token2 = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(token1.nextToken());
        int width = Integer.parseInt(token1.nextToken());
        int[] arr = new int[width];
        List<Integer> low = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            arr[i] = Integer.parseInt(token2.nextToken());
        }

        int total = 0;

        for (int i = 1; i < width - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for (int j = 0; j < i; j++) {
                leftMax = Math.max(arr[j], leftMax);
            }

            for (int j = i + 1; j < width; j++) {
                rightMax = Math.max(arr[j], rightMax);
            }

            if (arr[i] < leftMax && arr[i] < rightMax) {
                total += Math.min(leftMax, rightMax) - arr[i];
            }
        }
        System.out.println(total);
    }
}