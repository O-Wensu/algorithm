import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int[] setPrice = new int[m];
        int[] onePrice = new int[m];

        for (int i = 0; i < m; i++) {
            tk = new StringTokenizer(br.readLine());
            setPrice[i] = Integer.parseInt(tk.nextToken());
            onePrice[i] = Integer.parseInt(tk.nextToken());
        }

        //가격 오름차순 정렬
        Arrays.sort(setPrice);
        Arrays.sort(onePrice);

        int min = Integer.MAX_VALUE;
        int minSetPrice = setPrice[0];
        int minOnePrice = onePrice[0];

        //case1) 세트로 오버해서 구매하는 경우
        min = Math.min(min, minSetPrice * (n / 6 + 1));

        //case2) 낱개로 모두 구매하는 경우
        min = Math.min(min, minOnePrice * n);

        //case3) 세트 + 낱개로 구매하는 경우
        if (n > 6) {
            int setCount = n / 6;
            int total = minSetPrice * setCount + (n - setCount * 6) * minOnePrice;
            min = Math.min(min, total);
        }
        System.out.println(min);
    }
}