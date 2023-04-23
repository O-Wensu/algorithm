import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer tk = new StringTokenizer(br.readLine());
            Set<Integer> hashSet = new HashSet<>();

            for (int j = 0; j < N; j++) {
                hashSet.add(Integer.parseInt(tk.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            tk = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                if (hashSet.contains(Integer.parseInt(tk.nextToken()))) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}