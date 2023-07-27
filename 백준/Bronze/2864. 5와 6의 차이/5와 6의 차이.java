import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        String a = tk.nextToken();
        String b = tk.nextToken();

        String minA = a.replace('6', '5');
        String minB = b.replace('6', '5');

        int min = Integer.parseInt(minA) + Integer.parseInt(minB);

        String maxA = a.replace('5', '6');
        String maxB = b.replace('5', '6');

        int max = Integer.parseInt(maxA) + Integer.parseInt(maxB);

        System.out.println(min + " " + max);
    }
}