import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] chars = br.readLine().toCharArray();
        int[] alphabets = new int[26];
        Arrays.fill(alphabets, -1);

        for (int i = 0; i < chars.length; i++) {
            int index = (int)chars[i] - 97;
            if (alphabets[index] == -1){
                alphabets[index] = i;
            }
        }
        Arrays.stream(alphabets).forEach(i -> sb.append(i + " "));
        System.out.println(sb.toString());
    }
}