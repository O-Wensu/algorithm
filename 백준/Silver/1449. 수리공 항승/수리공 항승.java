import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int L = Integer.parseInt(tk.nextToken());
        int[] holes = new int[N];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            holes[i] = Integer.parseInt(tk.nextToken());
        }
        //오름차순 정렬
        Arrays.sort(holes);

        double left = holes[0] - 0.5;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (left + L < holes[i]) {
                cnt++;
                left = holes[i] - 0.5;
            }
        }
        System.out.println(cnt);
    }
}