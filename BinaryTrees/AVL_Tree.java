package BinaryTrees;
import Json.*;

public class AVL_Tree {
	//Attributes
	private AVL_Node root;
	//Constructor
	public AVL_Tree () {
		root = null;
	}
	//Checks if tree is empty
	public boolean isEmpty () {
		return root == null;
	}
	//Empties the tree
	public void EmptyTree () {
		root = null;
	}
	//Inserts a node in the tree
	public void insert (AVL_Node t) {
		root = insert (t, root);
	}
	//Sets the tree's height
	public int height (AVL_Node t) {
		return t == null ? -1 : t.height;
	}
	//Sets the max node
	private int max (int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}
	//Performs the function to insert a node in a tree
	private AVL_Node insert (AVL_Node x, AVL_Node t) {
		if (t == null) {
			t = new AVL_Node (x.data);
		}
		else if (x.toASCII()[0] < t.toASCII()[0]) {
			t.left = insert (x, t.left);
			if (height (t.left) - height (t.right) == 2) {
				if (x.toASCII()[0] < t.left.toASCII()[0]) {
					t = rotateWithLeftChild (t);
				} else {
					t = doubleWithLeftChild (t);
				}
			}
		}
		else if (x.toASCII()[0] > t.toASCII()[0]) {
			t.right = insert (x, t.right);
			if (height (t.right) - height (t.left) == 2) {
				if (x.toASCII()[0] > t.right.toASCII()[0]) {
					t = rotateWithRightChild (t);
				} else {
					t = doubleWithRightChild (t);
				}
			}
		} else {
			;
		}
		t.height = max( height( t.left ), height( t.right ) ) + 1;
		return t;
	}
	//Rotates the left child with his parent
	private AVL_Node rotateWithLeftChild (AVL_Node k2) {
		AVL_Node k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max (height (k2.left), height (k2.right)) + 1;
		k2.height = max (height (k1.left), k2.height) + 1;
		return k1;
	}
	//Calls the function to rotate
	private AVL_Node doubleWithLeftChild (AVL_Node k3) {
		k3.left = rotateWithRightChild (k3.left);
		return rotateWithLeftChild (k3.left);
	}
	//Rotates the right child with his parent
	private AVL_Node rotateWithRightChild (AVL_Node k1) {
		AVL_Node k2 = k1.left;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max (height (k1.left), height (k1.left)) + 1;
		k2.height = max (height (k2.right), k1.height) + 1;
		return k2;
	}
	//Calls the function to rotate
	private AVL_Node doubleWithRightChild (AVL_Node k1) {
		k1.right = rotateWithRightChild (k1.right);
		return rotateWithLeftChild (k1.right);
	}
	//Counts the nodes in the tree
	public int countNodes (AVL_Node r) {
		if (r == null) {
			return 0;
		} else {
			int i = 1;
			i += countNodes (r.left);
			i += countNodes (r.right);
			return i;
		}
	}
	//Searches a node in the tree
	public boolean contains (AVL_Node val) {
		return contains (root, val);
	}
	//Performs the function to search a node
	public boolean contains (AVL_Node r, AVL_Node val) {
		boolean found = false;
		while ((r != null) && !found) {
			if (val.toASCII()[0] < r.toASCII()[0]) {
				r = r.left;
			}
			else if (val.toASCII()[0] > r.toASCII()[0]) {
				r = r.right;
			} else {
				found = true;
				break;
			}
			found = contains (r, val);
		}
		return found;
	}
	//Orders the tree
	public void inorder () {
		inorder (root);
	}
	//Performs the inorder function
	public void inorder (AVL_Node r) {
		if (r != null) {
			inorder (r.left);
			System.out.println(r.data + "");
			inorder (r.right);
		}
	}
	//Orders the tree
	public void preorder () {
		preorder (root);
	}
	//Performs the preorder function
	public void preorder (AVL_Node r) {
		if (r != null) {
			System.out.println(r.data + "");
			preorder (r.left);
			preorder (r.right);
		}
	}
	//Orders the tree
	public void postorder () {
		postorder (root);
	}
	//Performs the postorder function
	public void postorder (AVL_Node r) {
		postorder (r.left);
		postorder (r.right);
		System.out.println(r.data + "");
	}
	//Turns the tree into an array
	public int[] toBSTArray () {
		int size = countNodes(root);
		int[] Array = new int [size];
		toArray(root, Array, 0);
		return Array;
	}
	//Performs the operation which turns nodes into array[]
	private int toArray (AVL_Node n, int[] Array, int i) {
		if (n.getLeft() != null) {
			i = toArray (n.getLeft(), Array, i);
		}
		if (n.getRight() != null) {
			i = toArray (n.getRight(), Array, i);
		}
		Array[i] = n.toASCII()[0];
		return i + 1;
	}
}
