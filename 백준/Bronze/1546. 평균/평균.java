import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int size = Integer.parseInt(br.readLine());
        double[] arr = new double[size];
        StringTokenizer tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(tk.nextToken());
            arr[i] = num;
            max = Math.max(max, num);
        }
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * 100 / max;
        }
        System.out.println(sum / size);
    }
}