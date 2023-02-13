import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(tk.nextToken());
        int N = Integer.parseInt(tk.nextToken());

        boolean[] prime = new boolean[N+1];

        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }

        for (int i = M; i <= N; i ++) {
            if (!prime[i]) bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
    }
}