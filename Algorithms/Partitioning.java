package Algorithms;

import java.util.Arrays;

public class Partitioning {
	private static int[] myArray;
	private static int arraySize;
	public static void main(String[] args) {
		Partitioning partition = new Partitioning(10);
		partition.generateRandomArray();
		System.out.println(Arrays.toString(Partitioning.myArray));
		partition.partitionArray(35);
		System.out.println(Arrays.toString(Partitioning.myArray));
	}
	Partitioning (int newArraySize) {
		arraySize = newArraySize;
		myArray = new int [arraySize];
		generateRandomArray();
	}
	public void generateRandomArray() {
		for (int i = 0; i < arraySize; i++) {
			myArray [i] = (int)(Math.random() * 50) + 10;
		}
	}
	public void partitionArray (int pivot) {
		int leftPointer = -1;
		int rightPointer = arraySize;
		while (true) {
			while (leftPointer < (arraySize - 1) && myArray [++leftPointer] < pivot) 
				;
			printHorzArray (leftPointer, rightPointer);
			System.out.println(myArray [leftPointer] + " in index " + leftPointer + " is bigger than " + pivot);
			while (rightPointer > 0 && myArray [--rightPointer] > pivot)
				;
			printHorzArray (leftPointer, rightPointer);
			System.out.println(myArray [rightPointer] + " in index " + rightPointer + " is smaller than " + pivot);
			if (leftPointer >= rightPointer) {
				break;
			} else {
				swapValues (leftPointer, rightPointer);
				System.out.println(myArray [leftPointer] + " was swapped for " + myArray [rightPointer]);
			}
		}
	}
	public void swapValues (int IndexOne, int IndexTwo) {
		int temp = myArray [IndexOne];
		myArray [IndexOne] = myArray [IndexTwo];
		myArray [IndexTwo] = temp;
	}
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
}
