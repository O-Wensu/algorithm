import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < size; i++) {
            String str = br.readLine();
            String first = String.valueOf(str.charAt(0));
            String result = first.toUpperCase() + str.substring(1);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}