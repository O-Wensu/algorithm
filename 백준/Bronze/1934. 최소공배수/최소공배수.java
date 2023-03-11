import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            bw.write(LCM(a,b) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int GCD(int x, int y) {
        if (x % y == 0) return y;
        return GCD(y, x % y);
    }

    private static int LCM(int x, int y) {
        int gcd = GCD(x,y);
        return (x * y) / gcd;
    }
}