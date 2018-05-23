package BinaryTrees;

public class AVL_Tree {
	private AVL_Node root;
	public AVL_Tree () {
		root = null;
	}
	public boolean isEmpty () {
		return root == null;
	}
	public void EmptyTree () {
		root = null;
	}
	public void insert (AVL_Node t) {
		root = insert (t, root);
	}
	public int height (AVL_Node t) {
		return t == null ? -1 : t.height;
	}
	private int max (int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}
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
	private AVL_Node rotateWithLeftChild (AVL_Node k2) {
		AVL_Node k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max (height (k2.left), height (k2.right)) + 1;
		k2.height = max (height (k1.left), k2.height) + 1;
		return k1;
	}
	private AVL_Node doubleWithLeftChild (AVL_Node k3) {
		k3.left = rotateWithRightChild (k3.left);
		return rotateWithLeftChild (k3.left);
	}
	private AVL_Node rotateWithRightChild (AVL_Node k1) {
		AVL_Node k2 = k1.left;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max (height (k1.left), height (k1.left)) + 1;
		k2.height = max (height (k2.right), k1.height) + 1;
		return k2;
	}
	private AVL_Node doubleWithRightChild (AVL_Node k1) {
		k1.right = rotateWithRightChild (k1.right);
		return rotateWithLeftChild (k1.right);
	}
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
	public boolean contains (AVL_Node val) {
		return contains (root, val);
	}
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
	public void inorder () {
		inorder (root);
	}
	public void inorder (AVL_Node r) {
		if (r != null) {
			inorder (r.left);
			System.out.println(r.data + "");
			inorder (r.right);
		}
	}
	public void preorder () {
		preorder (root);
	}
	public void preorder (AVL_Node r) {
		if (r != null) {
			System.out.println(r.data + "");
			preorder (r.left);
			preorder (r.right);
		}
	}
	public void postorder () {
		postorder (root);
	}
	public void postorder (AVL_Node r) {
		postorder (r.left);
		postorder (r.right);
		System.out.println(r.data + "");
	}
}
