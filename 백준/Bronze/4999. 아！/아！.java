import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len1 = (br.readLine()).length();
        int len2 = (br.readLine()).length();
        String answer = "no";

        if (len1 >= len2) answer = "go";
        System.out.println(answer);
    }
}