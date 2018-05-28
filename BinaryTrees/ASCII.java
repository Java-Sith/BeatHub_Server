package BinaryTrees;

public class ASCII {
	private String input;
	private static ASCII instance;
	public static void main (String args[]) {
		String input = "The Great Gig in the Sky, Pink Floyd, Dark Side of the Moon";
		System.out.println(input);
		int[] ascii = ASCII.getInstance(input).toASCII();
		for (int i = 0; i < ascii.length; i++) {
			System.out.println(ascii[i] + " ");
		}
	}
	private ASCII() {
		
	}
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public static ASCII getInstance() {
		return instance;
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