package Java;

import java.util.ArrayList;

public class CompareArray {

	public static void main(String[] args) {

		int[] a = { 1, 6, 2, 7 };
		int[] b = { 1, 4, 2, 8 };

		ArrayList<Integer> al = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (a[i] == b[i]) {
				al.add(a[i]);
			}
		}
		System.out.println(al);
		Object[] S = al.toArray();

		for (Object Obj : S) {
			System.out.println(Obj);
		}
	}
}
