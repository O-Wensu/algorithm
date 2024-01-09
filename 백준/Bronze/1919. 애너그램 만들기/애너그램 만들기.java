import java.io.*;

public class Main {
    private static int SIZE = 26;

    private static int[] createCountAlphabet(String str) {
        int[] arr = new int[SIZE];
        for(char c: str.toCharArray()) {
            arr[c - 'a'] += 1;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int count = 0;
        int[] arrA = createCountAlphabet(a);
        int[] arrB = createCountAlphabet(b);
        for(int i = 0; i < SIZE; i++) {
            count += Math.abs(arrA[i] - arrB[i]);
        }
        System.out.println(count);
    }
}