import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int M = N * 2;
            int count = 0;
            boolean[] prime = new boolean[M+1];
            prime[0] = true;
            prime[1] = true;

            for (int i = 2; i * i < prime.length; i++) {
                if (prime[i]) continue;
                for (int j = i * i; j < prime.length; j+=i) {
                    prime[j] = true;
                }
            }
            for (int i = N + 1; i < M + 1; i++) {
                if (!prime[i]) count++;
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }
}