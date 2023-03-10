import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk1 = new StringTokenizer(br.readLine(), "-");
        int sum = Integer.MIN_VALUE;

        while(tk1.hasMoreTokens()) {
            StringTokenizer tk2 = new StringTokenizer(tk1.nextToken(), "+");
            int temp = 0;

            while(tk2.hasMoreTokens()) {
                temp += Integer.parseInt(tk2.nextToken());
            }

            if (sum == Integer.MIN_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}