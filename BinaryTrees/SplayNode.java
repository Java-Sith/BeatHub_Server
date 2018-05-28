package BinaryTrees;

public class SplayNode {
	SplayNode left, right, parent;
	String element;
	public SplayNode () {
		this (null, null, null, null);
	}
	public SplayNode (String ele) {
		this (ele, null, null, null);
	}
	public SplayNode (String ele, SplayNode left, SplayNode right, SplayNode parent) {
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.element = ele;
	}
	public SplayNode getLeft() {
		return left;
	}
	public void setLeft(SplayNode left) {
		this.left = left;
	}
	public SplayNode getRight() {
		return right;
	}
	public void setRight(SplayNode right) {
		this.right = right;
	}
	public SplayNode getParent() {
		return parent;
	}
	public void setParent(SplayNode parent) {
		this.parent = parent;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public int[] toASCII() {
		char[] character = element.toCharArray();
		int[] ascii = new int[element.length()];
		for (int i = 0; i < element.length(); i++) {
			ascii[i] = character[i];
		}
		return ascii;
	}
}
