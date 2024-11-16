package Java;

public class Strings {

	public static void main(String[] args) {

		// string is an object //String literal
		String s1 = "hello";
		//declaration of string
		String s2 = new String("Welcome");
		String s = "Rahul Shetty Academy";
		String[] splittedString = s.split("Shetty");
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		System.out.println(splittedString[1].trim());

		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.println(s.charAt(i));
		}
	}
}