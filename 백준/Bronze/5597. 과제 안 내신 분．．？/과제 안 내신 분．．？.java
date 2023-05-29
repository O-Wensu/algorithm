import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] student = new boolean[31];

        for(int i=1; i<29; i++) {
            int success = Integer.parseInt(br.readLine());
            student[success] = true;
        }
        for(int i=1; i<student.length; i++) {
            if(!student[i])
                bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}