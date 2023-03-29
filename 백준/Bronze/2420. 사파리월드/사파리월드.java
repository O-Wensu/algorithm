import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(tk.nextToken());
        long m = Integer.parseInt(tk.nextToken());
        long result = Math.abs(n-m);
        System.out.println(result);
    }
}