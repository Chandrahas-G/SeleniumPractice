package Java;

public class Prime {
	
	//static boolean f = false;
	
	public static void main(String[] args) {
		
		boolean f = checkPrime(29);
		
		if (f) {
			System.out.println("Not Prime");
		} else
			System.out.println("Prime");
	}

	public static boolean checkPrime(int a) {
		// int a = 31;
		boolean f = false;
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				f = true;
				break;
			}
		}
		return f;
	}
}
