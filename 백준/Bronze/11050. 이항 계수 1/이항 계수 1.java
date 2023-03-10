import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tk.nextToken());
        int k = Integer.parseInt(tk.nextToken());

        int result = factorial(n) / (factorial(k) * factorial(n - k));
        System.out.println(result);
    }

    private static int factorial(int i) {
        if (i == 0) return 1;

        return i * factorial(i - 1);
    }
}