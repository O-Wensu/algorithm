import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        Integer[] pens = new Integer[N];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pens[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(pens, Comparator.reverseOrder());

        int total = M * K;
        int sum = 0;
        int count = 0;
        for (Integer pen : pens) {
            sum += pen;
            count++;
            if (sum >= total) break;
        }
        if (sum < total) System.out.println("STRESS");
        else System.out.println(count);
    }
}