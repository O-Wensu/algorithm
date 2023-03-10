import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tk.nextToken());
            int y = Integer.parseInt(tk.nextToken());
            int dist = y - x;
            int max = (int) Math.sqrt(dist); //정수

            if (max == Math.sqrt(dist)) {
                bw.write(2 * max - 1 + "\n");
            } else {
                if (dist > max * max + max) bw.write((2 * max + 1) + "\n");
                else bw.write((2 * max) +"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}