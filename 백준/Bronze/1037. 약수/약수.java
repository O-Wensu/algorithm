import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int[] divisors = new int[size];
        int original = -1;
        for (int i = 0; i < size; i++) {
            divisors[i] = Integer.parseInt(tk.nextToken());
        }
        // 오름차순 정렬
        Arrays.sort(divisors);

        if (size % 2 == 0) {
            int lastIdx = divisors.length - 1;
            original = divisors[0] * divisors[lastIdx];
        } else { // ex) 16
            int centerIdx = size / 2;
            original = (int) Math.pow(divisors[centerIdx], 2);
        }
        System.out.println(original);
    }
}