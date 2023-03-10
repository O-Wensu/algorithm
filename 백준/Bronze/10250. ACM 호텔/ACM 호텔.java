import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(tk.nextToken()); //층수
            int w = Integer.parseInt(tk.nextToken()); //방수
            int n = Integer.parseInt(tk.nextToken()); //몇 번째 손님

            int floor;
            int room;
            if (n % h == 0) {
                floor = h;
                room = n / h;
            } else {
                floor = n % h;
                room = n / h + 1;
            }
            floor = floor * 100;
            bw.write(floor + room + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}