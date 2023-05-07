import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(tk.nextToken());
            String[] splits = tk.nextToken().split("");
            for (String split : splits) {
                bw.write(split.repeat(r));
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}