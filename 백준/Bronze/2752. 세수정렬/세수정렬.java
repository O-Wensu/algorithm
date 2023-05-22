import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];

        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        
        Arrays.sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}