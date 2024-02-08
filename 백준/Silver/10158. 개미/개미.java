import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(tk.nextToken());
        int H = Integer.parseInt(tk.nextToken());
        tk = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(tk.nextToken());
        int Q = Integer.parseInt(tk.nextToken());
        int T = Integer.parseInt(br.readLine());

        int currentX = (T + P) % (2 * W);
        int currentY = (T + Q) % (2 * H);
        if (currentX > W) currentX = 2 * W - currentX;
        if (currentY > H) currentY = 2 * H - currentY;
        System.out.printf("%d %d", currentX, currentY);
    }
}