import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int seriesNum = Integer.parseInt(br.readLine());
        int now = 666;
        int count = 0;
        while(true) {
            if (Integer.toString(now).contains("666")) {
                count++;
            }
            if (count == seriesNum) break;
            now++;
        }
        System.out.println(now);
    }
}