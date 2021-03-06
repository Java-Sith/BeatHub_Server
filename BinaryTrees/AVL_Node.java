package BinaryTrees;

public class AVL_Node {
	AVL_Node left, right;
	String data;
	int height;
	public AVL_Node () {
		left = null;
		right = null;
		data = null;
		height = 0;
	}
	public AVL_Node (String n) {
		left = null;
		right = null;
		data = n;
		height = 0;
	}
	public AVL_Node getLeft() {
		return left;
	}
	public void setLeft(AVL_Node left) {
		this.left = left;
	}
	public AVL_Node getRight() {
		return right;
	}
	public void setRight(AVL_Node right) {
		this.right = right;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int[] toASCII() {
		char[] character = data.toCharArray();
		int[] ascii = new int[data.length()];
		for (int i = 0; i < data.length(); i++) {
			ascii[i] = character[i];
		}
		return ascii;
	}
}
