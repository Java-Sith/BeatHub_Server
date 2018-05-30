package Algorithms;
import BinaryTrees.*;

public class RadixSort {
	//Performs the RadixSort algorithm
	public static void radixSort (int[] a) {
		int i, m = a[0], exp = 1, n = a.length;
		int[] b = new int[10];
		for (i = 0; i < n; i++) {
			if (a[i] > m) {
				m = a[i];
			}
		}
		while (m/exp > 0) {
			int[] bucket = new int[10];
			for (i = 0; i < n; i++) {
				bucket [(a[i]/exp)%10]++;
			}
			for (i = 1; i < 10; i++) {
				bucket[i] += bucket[i-1];
			}
			for (i = n-1; i >= 0; i--) {
				b[--bucket[(a[i]/exp)%10]] = a[i];
			}
			for (i = 0; i < n; i++) {
				a[i] = b[i];
			}
			exp *= 10;
		}
	}
	//Prints the array
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
	}
	public static void main (String args[]) {
		AVL_Node an1 = new AVL_Node ("Dark Side of the Moon");
		AVL_Node an2 = new AVL_Node ("Songs of Innocence");
		AVL_Node an3 = new AVL_Node ("Appetite for Destruction");
		AVL_Tree av = new AVL_Tree ();
		av.insert(an1);
		av.insert(an2);
		av.insert(an3);
		int[] myArray = av.toBSTArray();
		radixSort(myArray);
		printArray(myArray);
	}
}
