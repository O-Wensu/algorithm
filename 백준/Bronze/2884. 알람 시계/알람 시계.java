import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        br.close();
        int h = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        if (m < 45) {
            h--;
            m = 60 - (45 - m);
            if (h < 0) h = 23;
            System.out.println(h + " " + m);
        } else {
            m = m - 45;
            System.out.println(h + " " + m);
        }
    }
}