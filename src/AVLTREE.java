import java.math.*;

public class AVLTreeTest {

	public static void main(String[] args) {

		AVLTree tree = new AVLTree();

		tree.insertTree(10);
		tree.insertTree(20);
		tree.insertTree(30);
		tree.insertTree(40);
		tree.insertTree(50);
		tree.insertTree(25);

		tree.printinorder();
	}

}

class NodeAVL {
	int key, height;
	NodeAVL right;
	NodeAVL left;

	public NodeAVL(int d) {
		key = d;
		height = 1;

	}

}

class AVLTree {
	static NodeAVL root;

	int height(NodeAVL N) {
		if (N == null) {
			return 0;
		}
		return N.height;
	}

	NodeAVL rightRotate(NodeAVL y) {
		NodeAVL x = y.left;
		NodeAVL T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = Math.max(height(y.left), height(y.right) + 1);
		x.height = Math.max(height(x.left), height(x.right) + 1);
		return x;
	}

	NodeAVL leftRotate(NodeAVL x) {
		NodeAVL y = x.right;
		NodeAVL T2 = y.left;

		y.left = x;
		x.right = T2;
		x.height = Math.max(height(x.left), height(x.right) + 1);
		y.height = Math.max(height(y.left), height(y.right) + 1);
		return y;
	}

	void insertTree(int key) {
		root = insertAVLTree(root, key);
	}

	NodeAVL insertAVLTree(NodeAVL node, int key) {

		if (node == null)
			return (new NodeAVL(key));

		if (key < node.key)
			node.left = insertAVLTree(node.left, key);
		else if (key > node.key)
			node.right = insertAVLTree(node.right, key);
		else
			return node;

		node.height = 1 + Math.max(height(node.left), height(node.right));

		int balance = getBalance(node);

		if (balance > 1 && key < node.left.key)
			return rightRotate(node);

		if (balance < -1 && key > node.right.key)
			return leftRotate(node);

		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	int getBalance(NodeAVL node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	void printpreorder() {
		printpreorder(root);
	}

	void printpreorder(NodeAVL node) {
		if (node == null) {
			return;
		}
		System.out.println(node.key);
		printpreorder(node.left);
		printpreorder(node.right);

	}

	void printpostorder() {
		printpostorder(root);
	}

	void printpostorder(NodeAVL node) {
		if (node == null) {
			return;

		}
		printpostorder(node.left);
		printpostorder(node.right);
		System.out.println(node.key);

	}

	void printinorder() {
		printinorder(root);
	}

	void printinorder(NodeAVL node) {
		if (node == null) {
			return;
		}
		printinorder(node.left);
		System.out.println(node.key);
		printinorder(node.right);
	}

	int heightTree(NodeAVL root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(heightTree(root.left), heightTree(root.right));
	}

	boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;

		}

	}
}
