package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1991_트리순회 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodeCount = Integer.parseInt(br.readLine());
		Tree tree = new Tree();

		// 트리 입력
		for (int i = 0; i < nodeCount; i++) {
			String[] input = br.readLine().split(" ");
			tree.addTree(tree.rootNode, input[1], input[2], input[0]);
		}

		// 전위
		tree.preorder(tree.rootNode);
		System.out.println();
		
		//중위
		tree.inorder(tree.rootNode);
		System.out.println();
		
		//후위
		tree.postorder(tree.rootNode);
	}

}

class Tree {

	class Node {
		String name;
		Node left, right;

		Node(String name) {
			this.name = name;
		}
	}

	Node rootNode;

	public void addTree(Node node, String left, String right, String parent) {
		// root node 초기화
		if (node == null) {
			node = new Node(parent);
			rootNode = node;
		}

		if (node.name.equals(parent)) {
			if (!left.equals(".")) {
				Node leftChild = new Node(left);
				node.left = leftChild;
			}
			if (!right.equals(".")) {
				Node rightChild = new Node(right);
				node.right = rightChild;
			}
			return;
		}
		
		if (node.left != null)
			addTree(node.left, left, right, parent);
		if (node.right != null)
			addTree(node.right, left, right, parent);
	}

	public void preorder(Node node) {
		System.out.print(node.name);
		if (node.left != null) {
			preorder(node.left);
		}
		if (node.right != null) {
			preorder(node.right);
		}
	}
	
	public void inorder(Node node) {
		if(node.left != null) {
			inorder(node.left);
		}
		System.out.print(node.name);
		if(node.right != null) {
			inorder(node.right);
		}
	}
	
	public void postorder(Node node) {
		if(node.left != null) {
			postorder(node.left);
		}
		if(node.right != null) {
			postorder(node.right);
		}
		System.out.print(node.name);
	}

}