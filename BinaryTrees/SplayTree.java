package BinaryTrees;
import Json.*;

public class SplayTree {
	//Attributes
	private SplayNode root;
	private int count = 0;
	//Constructor function
	public SplayTree () {
		root = null;
	}
	//Checks if tree is empty
	public boolean isEmpty () {
		return root == null;
	}
	//Empties the tree
	public void clear () {
		root = null;
	}
	//Inserts a node in the tree
	public void insert (SplayNode e) {
		SplayNode z = root;
		SplayNode p = null;
        while (z != null) {
            p = z;
            if (e.toASCII()[0] < p.toASCII()[0])
                z = z.right;
            else 
                z = z.left;
        }
        z = new SplayNode();
        z.element = e.element;
        z.parent = p;
        if (p == null)
            root = z;
        else if (e.toASCII()[0] < p.toASCII()[0])
            p.right = z;
        else
            p.left = z;
        Splay(z);
        count++;
    }
	//Moves the left child to be the parent node
    public void makeLeftChildParent(SplayNode c, SplayNode p) {
        if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))
            throw new RuntimeException("WRONG");
        if (p.parent != null) {
            if (p == p.parent.left)
                p.parent.left = c;
            else 
                p.parent.right = c;
        }
        if (c.right != null)
            c.right.parent = p;
        c.parent = p.parent;
        p.parent = c;
        p.left = c.right;
        c.right = p;
    }
	//Moves the right child to be the parent node
    public void makeRightChildParent(SplayNode c, SplayNode p)
    {
        if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
            throw new RuntimeException("WRONG");
        if (p.parent != null)
        {
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }
        if (c.left != null)
            c.left.parent = p;
        c.parent = p.parent;
        p.parent = c;
        p.right = c.left;
        c.left = p;
    }
    //Performs the splay balancing operation
    private void Splay(SplayNode x) {
        while (x.parent != null) {
            SplayNode Parent = x.parent;
            SplayNode GrandParent = Parent.parent;
            if (GrandParent == null) {
                if (x == Parent.left)
                    makeLeftChildParent(x, Parent);
                else
                    makeRightChildParent(x, Parent);                 
            } else {
                if (x == Parent.left) {
                    if (Parent == GrandParent.left) {
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(x, Parent);
                    } else {
                        makeLeftChildParent(x, x.parent);
                        makeRightChildParent(x, x.parent);
                    }
                } else {
                    if (Parent == GrandParent.left){
                        makeRightChildParent(x, x.parent);
                        makeLeftChildParent(x, x.parent);
                    } else {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(x, Parent);
                    }
                }
            }
        }
        root = x;
    }
    //Removes a node
    public void remove(SplayNode e) {
        SplayNode node = find(e);
       delete(node);
    }
    //Performs the function to remove a node in the tree
    private void delete(SplayNode node) {
        if (node == null)
            return;
        Splay(node);
        if( (node.left != null) && (node.right !=null)) { 
            SplayNode min = node.left;
            while(min.right!=null)
                min = min.right;

            min.right = node.right;
            node.right.parent = min;
            node.left.parent = null;
            root = node.left;
        }
        else if (node.right != null) {
            node.right.parent = null;
            root = node.right;
        } 
        else if( node.left !=null) {
            node.left.parent = null;
            root = node.left;
        } else {
            root = null;
        }
        node.parent = null;
        node.left = null;
        node.right = null;
        node = null;
        count--;
    }
    //Counts the nodes currently on tree
    public int countNodes() {
        return count;
    }
    //Checks if a node is in the tree
    public boolean contains (SplayNode e) {
    	return find (e) != null;
    }
    //Performs the function to find a node
    private SplayNode find(SplayNode e) {
        SplayNode z = root;
        while (z != null)
        {
            if (e.toASCII()[0] < z.toASCII()[0])
                z = z.right;
            else if (e.toASCII()[0] > z.toASCII()[0])
                z = z.left;
            else
                return z;
        }
        return null;
    }
    //Orders the tree
    public void inorder() {
        inorder(root);
    }
    //Performs the inorder function
    private void inorder(SplayNode r) {
        if (r != null) {
            inorder(r.left);
            System.out.print(r.element +" ");
            inorder(r.right);
        }
    }
    //Orders the tree
    public void preorder() {
        preorder(root);
    }
    //Performs the preorder function
    private void preorder(SplayNode r) {
        if (r != null) {
            System.out.print(r.element +" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    //Orders the tree
    public void postorder() {
        postorder(root);
    }
    //Performs the postorder function
    private void postorder(SplayNode r) {
        if (r != null) {
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.element +" ");
        }
    }
    //Turns the tree into an array
	public int[] toBSTArray () {
		int size = count;
		int[] Array = new int [size];
		toArray(root, Array, 0);
		return Array;
	}
	//Performs the operation which turns nodes into array[]
	private int toArray (SplayNode n, int[] Array, int i) {
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
