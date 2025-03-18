package Java;

public class CharOccurence {

	public static void main(String[] args) {

		String Name = "Chandrahas";
		char Character = 'a';
		int Count = 0;
		for (int i = 0; i < Name.length(); i++) {
			if(Name.charAt(i)==Character) {
				Count++;
			}
		}
		System.out.println(Count);
	}

}
