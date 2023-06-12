import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());    
        int B = Integer.parseInt(br.readLine());    
        int C = Integer.parseInt(br.readLine());    
        int D = Integer.parseInt(br.readLine());    

        int sum1 = 0;

        int[] total = new int[] {A, B, C, D};
        Arrays.sort(total);
        sum1 = total[1]+total[2]+total[3];

        int E = Integer.parseInt(br.readLine());   
        int F = Integer.parseInt(br.readLine());   

        int sum2 = Math.max(E, F);

        System.out.println(sum1 + sum2);
    }
}