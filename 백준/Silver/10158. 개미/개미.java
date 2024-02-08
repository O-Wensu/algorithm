import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int T = sc.nextInt();

        int dx = 1;
        int timeX = T % (2 * W);
        while(timeX --> 0) {
            if (P == W) dx = -1;
            else if (P == 0) dx = 1;
            P += dx;
        }

        int dy = 1;
        int timeY = T % (2 * H);
        while(timeY --> 0) {
            if (Q == H) dy = -1;
            else if (Q == 0) dy = 1;
            Q += dy;
        }
        System.out.printf("%d %d", P, Q);
    }
}