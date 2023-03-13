import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());

        int gcd = gcd(n, m);
        int lcm = lcm(n, m, gcd);
        bw.write(gcd + "\n" + lcm);
        bw.flush();
        bw.close();
        br.close();
    }

    private static int gcd(int x, int y) {
        if (x % y == 0) return y;
        return gcd(y, x % y);
    }

    private static int lcm(int x, int y, int gcd) {
        return (x * y) / gcd;
    }
}