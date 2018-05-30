package Algorithms;
import BinaryTrees.*;

public class QuickSort {
	//Attributes
	private static int[] myArray;
	private static int arraySize;
	public static void main(String[] args) {
		QuickSort theSort = new QuickSort(10);
		theSort.quickSort(0, 9);
	}
	//Constructor
	QuickSort (int newArraySize) {
		arraySize = newArraySize;
		myArray = new int [arraySize];
	}
	//Partitions the array and sets a pivot
	public int partitionArray (int left, int right, int pivot) {
		int leftPointer = left -1;
		int rightPointer = right;
		while (true) {
			while (leftPointer < (arraySize - 1) && myArray [++leftPointer] < pivot) 
				;
			printHorzArray (leftPointer, rightPointer);
			System.out.println(myArray [leftPointer] + " in index " + leftPointer + " is bigger than " + pivot);
			while (rightPointer > 0 && myArray [--rightPointer] > pivot)
				;
			printHorzArray (leftPointer, rightPointer);
			System.out.println(myArray [rightPointer] + " in index " + rightPointer + " is bigger than " + pivot);
			if (leftPointer >= rightPointer) {
				break;
			} else {
				swapValues (leftPointer, rightPointer);
				System.out.println(myArray [leftPointer] + " was swapped for " + myArray [rightPointer]);
			}
		}
		swapValues (leftPointer, right);
		return leftPointer;
	}
	//Swaps the values of an array by comparing them
	public void swapValues (int IndexOne, int IndexTwo) {
		int temp = myArray [IndexOne];
		myArray [IndexOne] = myArray [IndexTwo];
		myArray [IndexTwo] = temp;
	}
	//Prints the arrays
	static void printHorzArray (int i, int j) {
		for (int n = 0; n < 61; n++) {
			System.out.print("-");
		}
		System.out.println();
		for (int n = 0; n < arraySize; n++) {
			System.out.format("| %2s " + " ", n);
		}
		System.out.println("|");
		for (int n = 0; n < 61; n++) {
			System.out.print("-");
		}
		System.out.println();
		for (int n = 0; n < arraySize; n++) {
            System.out.print(String.format("| %2s " + " ", myArray[n]));
		}
		System.out.println("|");
		for (int n = 0; n < 61; n++) {
			System.out.print("-");
		}
		System.out.println();
		if (i != -1) {
			int SpacesBeforeFront = 5 * i + 1;
			for (int k = 0; k < SpacesBeforeFront; k++) {
				System.out.print(" ");
			}
			System.out.print("L");
			int SpacesBeforeRear = (5 * j + 1 - 1) - SpacesBeforeFront;
			for (int l = 0; l < SpacesBeforeRear; l++) {
				System.out.print(" ");
			}
			System.out.print("H");
			System.out.println("\n");
		}
	}
	//Performs the QuickSort algorithm
	public void quickSort (int left, int right) {
		if (right - left <= 0) {
			return;
		} else {
			int pivot = myArray [right];
			System.out.println(" Value in right " + myArray [right] + " is the pivot ");
			int pivotLocation = partitionArray (left, right, pivot);
			System.out.println(" Value in left " + myArray [right] + " is the pivot ");
			quickSort (left, pivotLocation - 1);
			quickSort (pivotLocation + 1, right);
		}
	}
}
