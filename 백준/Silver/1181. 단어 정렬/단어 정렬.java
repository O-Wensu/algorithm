import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            words.add(br.readLine());
        }
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });
        bw.write(words.get(0) + "\n");
        for(int i = 1; i < N; i++) {
            if (!words.get(i).equals(words.get(i-1))) {
                bw.write(words.get(i) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}