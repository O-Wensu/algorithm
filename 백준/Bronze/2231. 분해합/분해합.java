import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String num = Integer.toString(i);
            char[] digits = num.toCharArray();
            int sum = i;
            for (int j = 0; j < digits.length; j++) {
                sum += digits[j] - '0';
            }
            if (sum == n) {
                result = i;
                break;
            }
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println("0");
        } else {
            System.out.println(result);
        }
    }
}