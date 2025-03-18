package Java;

public class ReverseNum {

	public static void main(String[] args) {

		int Num = 3742;
		int reverse = 0;
		while (Num != 0) {
			int i = Num % 10;
			reverse = i + reverse * 10;
			Num = Num / 10;
			i++;
		}
		System.out.println(reverse);
	}
}
