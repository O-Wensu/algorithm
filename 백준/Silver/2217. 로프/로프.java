import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        int w = 0;

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);

        for (int i = 0; i < size; i++) {
            int temp = arr[i] * (size - i);
            w = Math.max(w, temp);
        }
        System.out.println(w);
    }
}