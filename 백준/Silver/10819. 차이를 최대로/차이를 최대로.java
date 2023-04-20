import java.io.*;
import java.util.*;

public class Main {
    static int size;
    static int[] numbers;
    static int[] arr;
    static boolean[] isUsed;
    static int max;
    
    public static void search(int depth) {
        if (depth == size) {
            int cal = 0;
            for (int i = 0; i < size - 1; i++) {
                cal += Math.abs(arr[i] - arr[i + 1]);
            }
            max = Math.max(max, cal);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (!isUsed[i]){
                isUsed[i] = true;
                arr[depth] = numbers[i];
                search(depth + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        numbers = new int[size];
        arr = new int[size];
        isUsed = new boolean[size];
        max = Integer.MIN_VALUE;

        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(tk.nextToken());
        }

        search(0);
        System.out.println(max);
    }
}