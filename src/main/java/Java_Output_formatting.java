import java.util.Scanner;
import java.text.DecimalFormat;


//Java_Output_Formatting
public class Java_Output_formatting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("000");
		System.out.println("================================");
		for (int i = 0; i < 3; i++) {
			String s1 = sc.next();
			int x = sc.nextInt();
			// Complete this line
			System.out.printf("%-15s", s1);
			System.out.printf(df.format(x)+"%n");
		}
		System.out.println("================================");

	}
}
