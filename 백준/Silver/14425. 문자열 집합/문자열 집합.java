import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        Map<String, Integer> words = new HashMap<>();

        //map 초기화
        for (int i = 0; i < n; i++) {
            words.put(br.readLine(), i);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (words.containsKey(br.readLine())) count++;
        }
        System.out.println(count);
    }
}