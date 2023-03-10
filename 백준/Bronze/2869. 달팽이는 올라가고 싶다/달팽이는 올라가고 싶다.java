import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(tk.nextToken());
        int b = Integer.parseInt(tk.nextToken());
        int v = Integer.parseInt(tk.nextToken());
        int dayHeight = a - b;
        int day = 0;
        
        v -= b;
        day = v / dayHeight;

        if (v % dayHeight != 0) {
            day++;
        }
        System.out.println(day);
    }
}