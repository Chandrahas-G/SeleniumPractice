package Java;

public class Multiply {

	public static void main(String[] args) {
		
		// multiplying without using * operator
		int sum = mult(5,10 );
		System.out.println(sum);
	}

	private static int mult(int a, int b) {
		int sum=0;
		for(int i=1; i<=b; i++) {
			sum=sum+a;
			//System.out.println(sum);
		}
		return sum;
	}

}
