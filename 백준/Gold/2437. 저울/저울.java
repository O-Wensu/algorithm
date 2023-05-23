import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] weights = new int[size];
        StringTokenizer tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < size; i++) {
            weights[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(weights);

        int sum = 0;
        for (int weight : weights) {
            if (sum + 1 < weight) {
                break;
            }
            sum += weight;
        }
        System.out.println(sum + 1);
    }
}