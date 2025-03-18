package Java;

public class Fibonacci {

	public static void main(String[] args) {

		// 0 1 1 2 3 5 8 13 21 34
		int a = 0;
		int b = 1;
		int sum = 0;
		
		int i = 0;
		while (i <= 9) {
			System.out.println(a);
			sum = a + b;

			a = b;
			b = sum;

			i++;
		}
	}
}
