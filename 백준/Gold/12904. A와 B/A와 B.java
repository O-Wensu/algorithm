import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        while(S.length() != T.length()) {
            if (T.endsWith("A")) {
                T = T.substring(0, T.length()-1);
            } else {
                T = T.substring(0, T.length()-1);
                T = new StringBuilder(T).reverse().toString();
            }
        }
        if (!S.equals(T)) {
            System.out.println("0");
            return;
        }
        System.out.println("1");
    }
}