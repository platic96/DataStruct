package example1;

import common.MyLinkedStack;

public class ParseTree {
	public class Node{
		char key;
		Node left;
		Node right;
		
		public Node(char key) {
			this.key = key;
			left = right = null;
		}
	}
	
	//��� �ʵ�
	Node root;
	int count;
	
	//������
	public ParseTree(){
		root = null;
		count =0;
	}
	
	public int getCount() {
		return count;
	}
	
	public int getNodeKey() {
		return root.key;
	}
	//�޼���
	
	//1. ���ĳ��� ���� [�ǿ����ڴ� 1�� �ڸ��� ����]
	void MakeParseTree(String str) {
		String[] tmp = str.split(" ");
		MyLinkedStack st = new MyLinkedStack();
		for(int i=0;i<tmp.length;i++) {
			if(IsOperate(tmp[i].charAt(0))) {
				Node newnode = new Node(tmp[i].charAt(0));
				count++;
				Node right = (Node)st.Pop();
				Node left = (Node)st.Pop();
				newnode.right = right;
				newnode.left = left;
				st.Push(newnode);
			}
			else {
				Node newnode = new Node(tmp[i].charAt(0));
				count++;
				st.Push(newnode);
			}
		}
		this.root = (Node)st.Pop();
	}
	
	//1.1 �����ڸ� �ĺ��ϴ� �Լ�
	private boolean IsOperate(int value) {
		if( value == '+' || value == '-' || value =='*' || value =='*')
			return true;
		else
			return false;
	}
	
	//2. ��ȸ�ڵ�(���/�����-����)
	//����
	private void InnerPreOrder(Node root) {
		System.out.print(root.key + " ");
		if(root.left != null)
			this.InnerPreOrder(root.left);
		if(root.right != null)
			this.InnerPreOrder(root.right);
	}
	
	public void PreOrder() {
		InnerPreOrder(root);		
	}
	
	//����
	private void InneriInOrder(Node root) {
		if(root.left != null)
			this.InneriInOrder(root.left);
		System.out.print(root.key + " ");
		if(root.right != null)
			this.InneriInOrder(root.right);
	}
	
	public void InOrder() {
		InneriInOrder(root);
	}
	
	//����
	private void InnerPostOrder(Node root) {
		if(root.left != null)
			this.InnerPostOrder(root.left);
		if(root.right != null)
			this.InnerPostOrder(root.right);
		System.out.print(root.key + " ");
	}
	
	public void PostOrder(){
		InnerPostOrder(root);
	}
	
	public void PreOrder_Non() {
		//1. ��Ʈ ��带 ���ؿ� Push
		//2. �ݺ��� ( ������ ������� �ʴٸ�)
		MyLinkedStack st = new MyLinkedStack();
		st.Push(root);
		while(!st.IsEmpty()) {
			Node node = (Node)st.Pop();
			if(node != null) {
				System.out.print((char)node.key + " ");
				st.Push(node.right);
				st.Push(node.left);
			}
		}
		System.out.println();
	}

	public void InOrder_Non() {
		Node cur = root;
		MyLinkedStack st = new MyLinkedStack();
		while(true) {
			while(cur!=null) {
				st.Push(cur);
				cur = cur.left;
			}
			if(st.IsEmpty() == false) {
				cur = (Node)st.Pop();
				System.out.print((char)cur.key+" ");
				cur = cur.right;
			}
			else 
				break;
		}
		System.out.println();
	}
}
