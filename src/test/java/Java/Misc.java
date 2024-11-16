package Java;

public class Misc {

	int a=10;
	public static void main(String[] args) {
		int a=20;
		System.out.println(a);
		Misc misc = new Misc();
		misc.print();
	}
	public void print() {

		System.out.println(this.a);
	}
}
