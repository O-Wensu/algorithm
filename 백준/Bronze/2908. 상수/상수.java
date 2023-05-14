import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[2];
        int max = Integer.MIN_VALUE;
        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder(tk.nextToken()).reverse();
            arr[i] = Integer.parseInt(sb.toString());
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }
}