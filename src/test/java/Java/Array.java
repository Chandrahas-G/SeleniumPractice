package Java;

public class Array {

	public static void main(String[] args) {

		double[] arr = { 2, 5.5, 6, 7.5, 9 };

		System.out.println("First Element is " + arr[0]);
		System.out.println("Last Element is " + arr[4]);

		System.out.println("Array in Normal Order is:");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("Array in reverse order is:");
		// reverse order
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
		// length of array
		System.out.println("Length of this array is " + arr.length);
	}
}
