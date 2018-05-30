package Algorithms;
import BinaryTrees.*;
import Json.Song;
import Json.Utility;

public class BubbleSort {
	//BubbleSort algorithm function
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
	//Prints the array to test the function
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
	}
	public static void main (String args[]) {
		Song song1 = new Song();
		Song song2 = new Song();
		Song song3 = new Song();
		song1.setAuthor("Metallica");
		song2.setAuthor("Bon Jovi");
		song3.setAuthor("Slash");
		SplayNode sn1 = new SplayNode(song1.getAuthor());
		SplayNode sn2 = new SplayNode(song2.getAuthor());
		SplayNode sn3 = new SplayNode(song3.getAuthor());
		SplayTree sp = new SplayTree ();
		sp.insert(sn1);
		sp.insert(sn2);
		sp.insert(sn3);
		int[] myArray = sp.toBSTArray();
		bubbleSort(myArray);
		printArray (myArray);
	}
}
