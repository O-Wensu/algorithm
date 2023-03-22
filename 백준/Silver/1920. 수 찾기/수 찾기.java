import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sizeA = Integer.parseInt(br.readLine());
        int[] a = new int[sizeA];
        StringTokenizer tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < sizeA; i++) {
            a[i] = Integer.parseInt(tk.nextToken());
        }

        int sizeB = Integer.parseInt(br.readLine());
        int[] b = new int[sizeB];
        tk = new StringTokenizer(br.readLine());

        for (int i = 0; i <sizeB; i++) {
            b[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(a);
        
        for (int i = 0; i < sizeB; i++) {
            int target = b[i];
            int start = 0;
            int end = sizeA - 1;
            int result = 0;
            while(start <= end) {
                int mid = (start + end) / 2;
                if (target == a[mid]) {
                    result = 1;
                    break;
                }
                if (target < a[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}