package Java;

public class AdjacentArray {

	public static void main(String[] args) {

		// max diff bw 2 values
		int[] a = { 2, 4, 9, 12, 16 };
		int diff = 0;
		for (int i = 0; i < a.length - 1; i++) {

			if (a[i + 1] - a[i] > diff) {
				diff = a[i + 1] - a[i];
			}

		}
		System.out.println(diff);
	}
}
