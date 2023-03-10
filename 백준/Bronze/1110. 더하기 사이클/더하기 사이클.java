import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int original = Integer.parseInt(br.readLine());
        int newNumber = original;
        int count = 0;

        while(true) {
            int first = newNumber / 10;
            int second = newNumber % 10;
            int sum = first + second;
            int secondOfSum = sum % 10;
            newNumber = second * 10 + secondOfSum;
            count++;
            if (original == newNumber) break;
        }
        System.out.println(count);
    }
}