import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
            max = Math.max(max, arr[i]);
        }

        boolean[] isNotPrime = new boolean[max + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i< isNotPrime.length; i++) {
            if (isNotPrime[i]) continue;
            for (int j = i * i; j < isNotPrime.length; j += i) {
                isNotPrime[j] = true;
            }
        }

        int count = 0;
        for (int i : arr) {
            if (!isNotPrime[i]) count++;
        }
        System.out.println(count);
    }
}