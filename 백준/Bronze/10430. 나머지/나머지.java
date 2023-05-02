import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(tk.nextToken());
        int B = Integer.parseInt(tk.nextToken());
        int C = Integer.parseInt(tk.nextToken());

        sb.append((A + B) % C + "\n");
        sb.append(((A % C) + (B % C)) % C + "\n");
        sb.append((A * B) % C + "\n");
        sb.append(((A % C) * (B % C)) % C+ "\n");
        System.out.println(sb.toString());
    }
}