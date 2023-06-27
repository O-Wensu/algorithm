import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        int n = split.length;
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        for (Integer i : arr) {
            System.out.print(i);
        }
    }
}