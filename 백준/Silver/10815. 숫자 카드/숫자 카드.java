import java.util.*;
import java.io.*;

public class Main {
    static int[] myNumbers;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer tk = new StringTokenizer(br.readLine());
        myNumbers = new int[n];

        for (int i = 0; i < n; i++) {
            myNumbers[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(myNumbers);

        int m = Integer.parseInt(br.readLine());
        tk = new StringTokenizer(br.readLine());
        int[] numbers = new int[m];

        for (int i = 0; i < m; i++) {
            numbers[i] = Integer.parseInt(tk.nextToken());
        }

        for (int number : numbers) {
            sb.append(hasNumber(number)).append(" ");
        }

        System.out.println(sb);
    }

    static int hasNumber(int compare) {
        int left = 0;
        int right = myNumbers.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (myNumbers[mid] < compare) {
                left = mid + 1;
            } else if (myNumbers[mid] > compare) {
                right = mid - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}