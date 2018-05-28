package Algorithms;

import java.util.Arrays;

public class ASCII {
	private String input;
	private static ASCII instance;
	public static void main (String[] args) {
		String input = "Drake, God's Plan, 2018";
		int ascii[] = ASCII.getInstance(input).toASCII();
		System.out.println("Plain Text\n" + input + "\n");
		System.out.println("Text to ASCII\n" + Arrays.toString(ascii) + "\n");
	}
	private ASCII() {
		
	}
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	} 

	public static void setInstance(ASCII instance) {
		ASCII.instance = instance;
	}

	public static ASCII getInstance(String input) {
		if (instance == null) {
			instance = new ASCII();
		}
		instance.setInput(input);
		return instance;
	}
	public int[] toASCII() {
		char[] character = input.toCharArray();
		int[] ascii = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			ascii[i] = character[i];
		}
		return ascii;
	}
}
