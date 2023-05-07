import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(tk.nextToken());
        String result = "";
        if (start == 1) {
            result = "ascending";
            for (int i = 2; i <= 8; i++) {
                if (Integer.parseInt(tk.nextToken()) != i) {
                    result = "mixed";
                    break;
                }
            }
        } else {
            result = "descending";
            for (int i = 7; i >= 1 ; i--) {
                if (Integer.parseInt(tk.nextToken()) != i) {
                    result = "mixed";
                    break;
                }
            }
        }
        System.out.println(result);
    }
}