import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int X = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(tk.nextToken());
            if (map.containsKey(X - n)) count++;
            map.put(n, 0);
        }
        System.out.println(count);
    }
}