import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] count = new int[26];
        int max = Integer.MIN_VALUE;
        char answer = ' ';
        for (char c: word.toCharArray()) {
            char upperChar = Character.toUpperCase(c);
            int index = upperChar - 'A';
            count[index] += 1;
            if (max < count[index]) {
                max = count[index];
                answer = upperChar;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (i == answer - 'A') continue;
            if (max == count[i]) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}