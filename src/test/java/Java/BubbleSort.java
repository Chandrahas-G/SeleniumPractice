package Java;

public class BubbleSort {

	public static void main(String[] args) {

		int arr[] = { 5, 8, 3, 6, 9 };
		//ascendSort(arr);
		descendSort(arr);
		printArray(arr);
	}

	public static void ascendSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void descendSort(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					// Swap
					//int temp = arr[j];
					//arr[j] = arr[i];
					//arr[i] = temp;
					
					arr[i] = arr[i]+arr[j];
					arr[j] = arr[i]-arr[j];
					arr[i] = arr[i]-arr[j];
				}
			}
		}
	}

	public static void printArray(int arr[]) {
		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
		System.out.println(" ");
	}
}