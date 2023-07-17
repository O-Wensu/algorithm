import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        List<Integer> ls = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            tk = new StringTokenizer(br.readLine());
            while(tk.hasMoreTokens()) {
                int temp = Integer.parseInt(tk.nextToken());
                ls.add(temp);
            }
        }

        Collections.sort(ls);
        StringBuilder sb = new StringBuilder();
        for (Integer l : ls) {
            sb.append(l + " ");
        }
        System.out.println(sb);
    }
}