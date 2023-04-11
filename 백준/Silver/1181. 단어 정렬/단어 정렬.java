import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        String[] words = new String[size];
        for (int i = 0; i < size; i++) {
            words[i] = br.readLine();
        }
        String[] distinctWords = Arrays.stream(words).distinct().toArray(String[]::new);
        Arrays.sort(distinctWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        for (String word : distinctWords) {
            bw.write(word + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}