package example3;

import example1.ParseTree.Node;

public class MyBSearchTree {
	public class Node{
		int key;
		Node left;
		Node right;

		
		public Node(int key) {
			this.key = key;
			left = right = null;
		}
	}
	private Node root;
	private int count;
	
	public MyBSearchTree() {
		root = null;
		count = 0;
	}
	
	//메서드
	//insert 알고리즘
		public void Insert(int key) {		
			if( root == null)
				root = new Node(key);
			else
				InnerInsert(root, key);	
		}
	private void InnerInsert(Node cur, int key) {
			if( cur.key > key) {
				if(cur.left != null)
					InnerInsert(cur.left, key);
				else {
					cur.left = new Node(key);
					count++;
				}
			}
			else if(cur.key < key)
				if(cur.right != null)
					InnerInsert(cur.right, key);
				else {
					cur.right = new Node(key);
					count++;
				}
			else if(cur.key == key)
				return;
		}

	public void Insert_NonRe(int key) {
		if( root == null) {
			root = new Node(key);  count++;
			return;
		}
		Node cur = root;
		while(true) {
			if(cur.key < key) {
				if(cur.right == null) {
					cur.right = new Node(key);  count++;
					break;
				}
				else
					cur = cur.right;
			}
			else if(cur.key > key){
				if(cur.left == null) {
					cur.left = new Node(key);  count++;
					break;
				}
				else
					cur = cur.left;
			}
			else if(cur.key == key)
				return;
		}
	}
	
	private Node InnerserSelect(Node cur, int key) {
		if(cur == null || cur.key == key)
			return cur;
		if(cur.key > key)
			return InnerserSelect(cur.left, key);
		else
			return InnerserSelect(cur.right, key);
	}
	
	public Node Search(int key) {
		if( root == null) {
			System.out.println("해당 값이 없습니다.");
			return null;
		}
		Node cur = root;
		while(true) {
			if (cur == null)
				break;
			else if(cur.key < key) {
				cur = cur.right;
			}
			else if(cur.key > key){
				cur = cur.left;
			}
			else if(cur.key == key)
				return cur;
		}
		return null;
	}
	//검증!
	public void InOrder() {
		System.out.println("저장개수 : " + count);
		InnerInOrder(root);
		System.out.println();
	}
	
	private void InnerInOrder(Node root) {		
		if(root.left != null)
			InnerInOrder(root.left);
		System.out.print((int)root.key + " ");
		if(root.right != null)
			InnerInOrder(root.right);
	}

	public boolean  Delete(int key) {
		Node del = root;
		Node parent = null;
		
		while((del != null) && del.key != key) {
			parent = del;
			if( key < del.key)
				del = del.left;
			else
				del = del.right;
		}
		if(del == null)
			return false;
		
		//삭제 알고리즘
		if(del.left == null && del.right == null) {
			if(parent == null)
				root = null;
			else {
				if(parent.left == del)
					parent.left = null;
				else
					parent.right = null;
			}	
		}
		else if(del.left == null || del.right == null) {
			Node child;
			if(del.left != null)
				child = del.left;
			else
				child = del.right;
			
			if(parent == null)
				root = child;
			else {
				if(parent.left == del)
					parent.left = child;
				else
					parent.right = child;
			}
		}
		else {
			Node succ_parent= del;;
			Node succ = del.right;
			
			while(succ != null) {
				succ_parent = succ;
				succ = succ.left;
			}
			
			if(succ_parent.left == succ)
				succ_parent.left = succ.right;
			else
				succ_parent.right = succ.right;
			
			del.key = succ.key;
		}
		count--;
		return true;
	}
}
