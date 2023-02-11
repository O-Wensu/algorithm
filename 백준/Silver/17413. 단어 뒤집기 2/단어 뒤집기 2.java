import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] result = br.readLine().split("");
        boolean reverse = true;

        for (String s: result) {
            if (reverse) {
                if (s.equals("<")) {
                    if (sb.length() != 0) {
                        bw.write(sb.reverse().toString());
                        sb.setLength(0);
                    }
                    bw.write(s);
                    reverse = false;
                } else if (s.equals(" ")) {
                    bw.write(sb.reverse()+ " ");
                    sb.setLength(0);
                } else {
                    sb.append(s);
                }
            } else {
                bw.write(s);
                if (s.equals(">")) reverse = true;
            }
        }
        if (sb.length() != 0) {
            bw.write(sb.reverse().toString());
        }
        bw.flush();
        bw.close();
    }
}