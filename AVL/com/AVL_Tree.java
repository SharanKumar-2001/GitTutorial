package AVL.com;

public class AVL_Tree {
	private Node root;

	public class Node {
		int value;
		int height;
		Node left;
		Node right;

		// constructor for Node class
		public Node(int value) {

			this.value = value;
		}

		// get method
		public int getValue() {
			return value;
		}

	}

	// Default constructor for BST class
	public AVL_Tree() {

	}

	public boolean isEmpty() {
		return root == null;
	}

	// This method is used for insert data, when the data is sorted. And it follows
	// the same insertion method
	public void populateSortedArray(int[] nums) {
		populateSortedArray(nums, 0, nums.length);
	}

	private void populateSortedArray(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		this.insert(nums[mid]);
		populateSortedArray(nums, start, mid);
		populateSortedArray(nums, mid + 1, end);

	}

//	get the items from an array
	public void populate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			this.insert(nums[i]);
		}
	}

	// This method is used for insert data.
	public void insert(int value) {
		root = insert(value, root);
	}

	private Node insert(int value, Node node) {
		if (node == null) {
			node = new Node(value);
			return node;
		}
		if (value < node.value) {
			node.left = insert(value, node.left);
		}

		if (value > node.value) {
			node.right = insert(value, node.right);
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return rotate(node);
	}

	private Node rotate(Node node) {
		if (height(node.left) - height(node.right) > 1) {
			// left Heavy
			if (height(node.left.left) - height(node.left.right) > 0) {
				// left left case
				return rightRotate(node);
			}
			if (height(node.left.left) - height(node.left.right) < 0) {
				// left right case
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		}
		
		if (height(node.left) - height(node.right) < -1) {
			// right Heavy
			if (height(node.right.left) - height(node.right.right) < 0) {
				// right right case
				return leftRotate(node);
			}
			if (height(node.left.left) - height(node.left.right) > 0) {
				//right left case
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		}

		return node;
	}
	

	private Node rightRotate(Node p) {
// here main node is p, after rotating c becomes main node that's why we return 'c'.
		Node c=p.left;
		Node t=c.right;
		
		c.right=p;
		p.left=t;
		
		p.height=Math.max(height(p.left), height(p.right))+1;
		c.height=Math.max(height(c.left), height(c.right))+1;

		return c;
	}

	private Node leftRotate(Node c) {
// here main node is c, after rotating p becomes main node that's why we return 'p'.

		Node p=c.right;
		Node t=p.left;
		
		p.left=c;
		c.right=t;
		
		p.height=Math.max(height(p.left), height(p.right) +1);
		c.height=Math.max(height(c.left), height(c.right) +1);

		
		return p;
	}

	// this method give the height of the tree
	public int height() {
		return height(root);
	}
	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}

	// it checks the tree is balanced or not
	public boolean balanced() {
		return balanced(root);
	}

	private boolean balanced(Node node) {
		if (node == null) {
			return true;
		}
		return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);

	}

	// Display function

	public void display() {
		display(root, "Root Node: ");
	}

	private void display(Node node, String details) {
		if (node == null) {
			return;
		}
		System.out.println(details + node.getValue());
		display(node.left, "Left child of " + node.getValue() + ":");
		display(node.right, "right child of " + node.getValue() + ":");
	}

	// types of traversals

	public void Inorder() {
		Inorder(root);
	}

	private void Inorder(Node node) {
		if (node == null) {
			return;
		}

		Inorder(node.left);
		System.out.println(node.value + "");
		Inorder(node.right);

	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.value + "");
		preorder(node.left);
		preorder(node.right);

	}

	public void postorder() {
		postorder(root);
	}

	private void postorder(Node node) {
		if (node == null) {
			return;
		}

		postorder(node.left);
		postorder(node.right);
		System.out.println(node.value + "");

	}

}
