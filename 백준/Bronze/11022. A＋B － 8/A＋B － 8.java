import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String args[]) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int A, B;
 
		StringTokenizer st;
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine()," ");
 
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
            
			bw.write("Case #"+i+": ");
			bw.write(A + " + " + B + " = ");
			bw.write((A+B) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
 
}