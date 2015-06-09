package trees;

public class PrintNodesAtKDistance<T extends Comparable<T>> {

	static class Node<T> {
		T t;
		Node<T> left;
		Node<T> right;
	}

	/*
	 * Recursive function to print all the nodes at distance k in the tree (or
	 * subtree) rooted with given root. See
	 */
	void printKDistanceNodeDown(Node<T> root, int k) {
		// Base Case
		if (root == null || k < 0)
			return;

		// If we reach a k distant node, print it
		if (k == 0) {
			System.out.println(root.t);
			return;
		}

		// Recur for left and right subtrees
		printKDistanceNodeDown(root.left, k - 1);
		printKDistanceNodeDown(root.right, k - 1);
	}

	// Prints all nodes at distance k from a given target node.
	// The k distant nodes may be upward or downward. This function
	// Returns distance of root from target node, it returns -1 if target
	// node is not present in tree rooted with root.
	int printKDistanceNode(Node<T> root, Node<T> target, int k) {
		// Base Case 1: If tree is empty, return -1
		if (root == null)
			return -1;

		// If target is same as root. Use the downward function
		// to print all nodes at distance k in subtree rooted with
		// target or root
		if (root == target) {
			printKDistanceNodeDown(root, k);
			return 0;
		}

		// Recur for left subtree
		int dl = printKDistanceNode(root.left, target, k);

		// Check if target node was found in left subtree
		if (dl != -1) {
			// If root is at distance k from target, print root
			// Note that dl is Distance of root's left child from target
			if (dl + 1 == k){
				System.out.println(root.t);
				return -1;
			}
			// Else go to right subtree and print all k-dl-2 distant nodes
			// Note that the right child is 2 edges away from left child
			else
				printKDistanceNodeDown(root.right, k - dl - 2);

			// Add 1 to the distance and return value for parent calls
			return 1 + dl;
		}

		// MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
		// Note that we reach here only when node was not found in left subtree
		int dr = printKDistanceNode(root.right, target, k);
		//System.out.println("dr value"+dr);
		if (dr != -1) {
			if (dr + 1 == k){
				System.out.println(root.t);
			// cout << root->data << endl;
				return -1;
			}
			else
				printKDistanceNodeDown(root.left, k - dr - 2);
			return 1 + dr;
		}

		// If target was neither present in left nor in right subtree
		return -1;
	}

	Node<T> root;

	void insert(T t) {
		Node<T> newNode = new Node<T>();
		newNode.t = t;
		if (root == null) {
			root = newNode;
		} else {
			Node<T> curr = root;
			Node<T> follow = null;

			while (curr != null) {
				int res = t.compareTo(curr.t);
				if (res < 0) {
					follow = curr;
					curr = curr.left;
				} else if (res > 0) {
					follow = curr;
					curr = curr.right;
				}
			}
			if (t.compareTo(follow.t) < 0) {
				follow.left = newNode;
			} else {
				follow.right = newNode;
			}
		}
	}

	void inorder(Node<T> root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.println(root.t);
		inorder(root.right);
	}

	private Node<T> returnTargetNode(T t) {

		Node<T> curr = root;
		while (curr != null) {
			if (curr.t.compareTo(t) == 0) {
				return curr;
			} else if (curr.t.compareTo(t) > 0) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}

		return null;
	}

	public static void main(String[] args) {
		PrintNodesAtKDistance<Integer> tree = new PrintNodesAtKDistance<Integer>();
		tree.insert(50);
		tree.insert(40);
		tree.insert(60);
		tree.insert(30);
		tree.insert(45);
		tree.insert(55);
		tree.insert(70);
		tree.insert(20);
		tree.insert(35);
		tree.insert(43);
		tree.insert(48);
		tree.insert(54);
		tree.insert(57);
		tree.insert(65);
		tree.insert(80);
		tree.insert(63);
		tree.insert(67);
		tree.insert(75);
		tree.insert(85);
		// tree.inorder(tree.root);
		// tree.inorder(tree.root);
		Node<Integer> target = tree.returnTargetNode(60);
		tree.printKDistanceNode(tree.root, target, 0);
	}

}
