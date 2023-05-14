import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(tk.nextToken());
            }
            if (arr[0] == 0) break;

            Arrays.sort(arr);
            if (Math.pow(arr[0],2) + Math.pow(arr[1],2) == Math.pow(arr[2],2)) {
                bw.write("right\n");
                continue;
            }
            bw.write("wrong\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}