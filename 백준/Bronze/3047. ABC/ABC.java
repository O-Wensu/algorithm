import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[3];
		
		for(int i=0; i<arr.length; i++)
			arr[i] = scan.nextInt();
		
		Arrays.sort(arr);
		
		String str = scan.next();
		for(int i=0; i<str.length(); i++) 
			System.out.print(arr[str.charAt(i) - 65] + " ");
		
		scan.close();
		
	}
}