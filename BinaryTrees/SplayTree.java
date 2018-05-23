package BinaryTrees;

public class SplayTree {
	private SplayNode root;
	private int count = 0;
	public SplayTree () {
		root = null;
	}
	public boolean isEmpty () {
		return root == null;
	}
	public void clear () {
		root = null;
	}
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
    public void remove(SplayNode e) {
        SplayNode node = find(e);
       delete(node);
    }
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
    public int countNodes() {
        return count;
    }
    public boolean contains (SplayNode e) {
    	return find (e) != null;
    }
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
    public void inorder() {
        inorder(root);
    }
    private void inorder(SplayNode r) {
        if (r != null) {
            inorder(r.left);
            System.out.print(r.element +" ");
            inorder(r.right);
        }
    }
    public void preorder() {
        preorder(root);
    }
    private void preorder(SplayNode r) {
        if (r != null) {
            System.out.print(r.element +" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    public void postorder() {
        postorder(root);
    }
    private void postorder(SplayNode r) {
        if (r != null) {
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.element +" ");
        }
    }   
}
