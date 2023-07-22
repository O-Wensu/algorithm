import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        long x = Long.parseLong(tk.nextToken()); //게임 횟수
        long y = Long.parseLong(tk.nextToken()); //승리 횟수
        long z =  y * 100 / x; //승률

        long start = 0;
        long end = x;
        long result = -1;

        if (z >= 99) {
            System.out.println(result);
            return;
        }

        while(start <= end) {
            long mid = (start + end) / 2;
            long winningRate = (y + mid) * 100 / (x + mid);

            //원래 승률보다 크다면
            if (winningRate > z) {
                result = mid;
                end = mid - 1;
            } else { //원래 승률보다 작거나 같다면
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}