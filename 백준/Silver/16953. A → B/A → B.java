import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int count = 0;

        mod(a,b,count);
    }

    public static void mod(int a, int b, int count) {
        if (a > b) {
            System.out.println("-1");
            return;
        } else if (a == b) {
            System.out.println(count+1);
            return;
        }
        if (b % 2 == 0) {
            mod(a, b / 2, count + 1);
        } else {
            String temp = Integer.toString(b);
            if (temp.charAt(temp.length()-1) == '1') {
                temp = temp.substring(0, temp.length()- 1);
                mod(a, Integer.parseInt(temp), count+1);
            } else {
                System.out.println("-1");
            }
        }
    }
}
