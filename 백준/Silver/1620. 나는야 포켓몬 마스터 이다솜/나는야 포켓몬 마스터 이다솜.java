import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, String> map1 = new HashMap<Integer, String>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		
		
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			map1.put(i, str);
			map2.put(str, i);
		}
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			//입력값이 번호인지 판별
			if(49 <= str.charAt(0) && str.charAt(0) <= 57) {
				sb.append(map1.get(Integer.parseInt(str))).append("\n");
			}else {
				sb.append(map2.get(str)).append("\n");
			}
		}
		System.out.println(sb);
	}

}