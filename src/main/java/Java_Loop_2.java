import java.util.Scanner;

/*
 * We use the integers a, b, and n to create the following series:
 (a+2^0.b), (a+2^0.b+2^1.b), ....., (a+2^0.b+2^1.b+...+(2^(n-1)).b)
You are given q queries in the form of a, b, and n. For each query, print the series corresponding to the given a, b, and n values as a single line of n space-separated integers.
 */
public class Java_Loop_2 {

	public static void main(String[] argh) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			int series_num = a;
			for (int j = 0; j < n; j++) {
				series_num = series_num + (power(2,j)*b);

				System.out.print(series_num+" ");
			}
			System.out.println();
		}
		in.close();
	}

	static int power(int num, int pow) {
		int result = num;

		if (pow == 0) {
			return 1;
		} else if (pow == 1) {
			return num;
		} else {
			for (int i = 1; i < pow; i++) {
				result = result * num;
			}
		}

		return result;
	}
}
