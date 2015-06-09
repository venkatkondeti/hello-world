package trees;

public class BinaryToDll<T extends Comparable<T>> {
	
	Node<T> root;
	void insert(T t){
		Node<T> newNode = new Node<T>();
		newNode.t=t;
		if(root==null){
			root = newNode;
		}else{
			Node<T> curr=root;
			Node<T> follow=null;
			
			while(curr!=null){
				int res=t.compareTo(curr.t);
				if(res<0){
					follow=curr;
					curr=curr.left;
				}else if(res>0){
					follow=curr;
					curr=curr.right;
				}
			}
			if(t.compareTo(follow.t)<0){
				follow.left=newNode;
			}else{
				follow.right= newNode;
			}
		}
	}
	
	void inorder(Node<T> root){
		if(root==null)
			return;
		inorder(root.left);
		System.out.println(root.t);
		inorder(root.right);
	}
	
	Node<T> binaryTree2DllUtil(Node<T> root){
		
		if(root==null)
			return root;
		
		if(root.left!=null){
			Node<T> left = binaryTree2DllUtil(root.left);
			for(;left.right!=null;left=left.right);
			left.right=root;
			root.left=left;
		}
		
		if(root.right!=null){
			Node<T> right = binaryTree2DllUtil(root.right);
			for(;right.left!=null;right=right.left);
			right.left=root;
			root.right=right;
		}
		return root;
	}
	
	void binaryToDll(){
		Node<T> curr = binaryTree2DllUtil(root);
		while(curr.left!=null){
			curr=curr.left;
		}
		
		for(Node<T> temp=curr;temp!=null;temp=temp.right){
			System.out.println(temp.t);
		}
	}
	
	public static void main(String[] args) {
		BinaryToDll<Integer> tree = new BinaryToDll<Integer>();
		tree.insert(80);
		tree.insert(70);
		tree.insert(60);
		tree.insert(90);
		tree.insert(50);
		tree.insert(100);
		
		//tree.inorder(tree.root);
		tree.binaryToDll();
	}
	
	static class Node<T> {
		T t;
		Node<T> left;
		Node<T> right;
	}
}
