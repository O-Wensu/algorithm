import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] LIS = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        LIS[0] = arr[0];
        int length = 1;

        for (int i = 1; i < n; i++) {
            int num = arr[i];

            if (LIS[length - 1] < num) {
                length++;
                LIS[length - 1] = num;
            } else {
                int start = 0;
                int end = length;

                while(start <= end) {
                    int mid = (start + end) / 2;
                    if (LIS[mid] < num) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                LIS[start] = num;
            }
        }
        System.out.println(length);
    }
}