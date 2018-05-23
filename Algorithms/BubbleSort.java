package Algorithms;

public class BubbleSort {
	public static void bubbleSort (int[] array) {
		for (int i = (array.length - 1); i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (array[j-1] > array[j]) {
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
	}
	public static void main (String args[]) {
		int[] array = {7, 5, 2, 4, 3, 9};
		printArray(array);
		bubbleSort(array);
		System.out.println();
		printArray(array);
	}
}
