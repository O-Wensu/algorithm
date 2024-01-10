import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();
        int count = 0;
        int startIndex = 0;
        while(true) {
            int findIndex = doc.indexOf(word, startIndex);
            if (findIndex < 0) break;
            startIndex = findIndex + word.length();
            count++;
        }
        System.out.println(count);
    }
}