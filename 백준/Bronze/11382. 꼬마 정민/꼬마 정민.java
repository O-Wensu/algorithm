import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        long a = Long.parseLong(tk.nextToken());
        long b = Long.parseLong(tk.nextToken());
        long c = Long.parseLong(tk.nextToken());
        System.out.println(a + b + c);
    }
}