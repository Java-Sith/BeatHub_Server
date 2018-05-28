package Algorithms;
import BinaryTrees.*;

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
		SplayNode sn1 = new SplayNode("Drake");
		SplayNode sn2 = new SplayNode("Bono");
		SplayNode sn3 = new SplayNode("Jon Bon Jovi");
		SplayNode sn4 = new SplayNode("Dr. Dre");
		SplayTree sp = new SplayTree ();
		sp.insert(sn1);
		sp.insert(sn2);
		sp.insert(sn3);
		sp.insert(sn4);
		int[] myArray = sp.toBSTArray();
		bubbleSort(myArray);
		printArray (myArray);
	}
}
