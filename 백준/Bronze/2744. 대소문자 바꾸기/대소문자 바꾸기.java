import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c: charArr) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
                continue;
            }
            sb.append(Character.toUpperCase(c));
        }
        System.out.println(sb);
    }
}