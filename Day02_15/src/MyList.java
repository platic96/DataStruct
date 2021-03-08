//MyList.java

public class MyList {
	private Node head;
	private int size;
	
	public MyList() {
		this.head = null;
		this.size = 0;
	}
	
	//���� ----------------------------------
	//1. ������(�ʱ�ȭ), 2. ���� �˰���
	public boolean front_Insert(Object data) {
		Node newnode = new Node(data);
		
		if(head == null)
			head = newnode;
		else {
			newnode.next = head;
			head = newnode;
		}
		size++;
		return true;
	}
	
	//���� ��忡 ����
	public boolean back_Insert(Object data) {
		Node newnode = new Node(data);
		
		if(head == null)
			head = newnode;
		else {
			//������ ã�� ����
			Node cur = head;
			while(cur.next != null) {
				cur = cur.next;
			}
			//����
			cur.next = newnode;
		}
		size++;
		return true;
	}
	
	// cur�� ���� ��忡 ���� ����§ �ҽ��� �Ϻ����� �� ����.
	public boolean random_Insert(Node cur, Object data) {

//		if(cur.next == null)
//			back_Insert(data);
//		else
//		{
//			Node newnode = new Node(data);
//			
//			Node start = head;
//			while(start.next != cur) {
//				continue;
//			}
//			if(start.next == null)
//				return false;
//			else {
//				newnode.next = start;
//				start = newnode;
//			}
//		}
		
		Node newnode = new Node(data);
		
		if(cur.next == null)
			cur.next = newnode;
		else
		{
			newnode.next = cur.next;
			cur.next = newnode;
		}
		size++;
		return true;
	}
	
	//���� ----------------------------------
	//1. ������ ��带 ã�´�. 2. ���� �˰���
	public boolean front_delete() {
		Node del = head;
		
		if(del == null) //��尡 ������
			return false;
		head = del.next;
		size--;
		return true;
	}

	//1. ������ ����(�������)�� ã�´�. 2. ���� �˰���
	public boolean back_delete() {
		Node del = head;
		Node prev = head;
		
		if(del == null) //��尡 ���� ����
			return false;
		
		if( del.next == null) { //��尡 �ϳ��� ��Ȳ
			head = null;
		}
		else {  //��尡 �ΰ� �̻��� ��Ȳ
			while( del.next != null) {
			    prev = del;
			    del = del.next;
			}
			prev.next = null;
		}
		size--;
		return false;
		
	}
	
	
	//cur�� ���� ��带 ����!
	public boolean random_delete(Node prev) {
			Node del = prev.next;
			
			if(del.next == null) {
				return false;
			}
			else {
				prev.next = del.next;		
			}
			size--;
			return true;
		}

	//��ȸ ----------------------------------
	public void selectall() {
		System.out.println("["+ size+"]");
		Node cur = head;
		
		while(cur != null) {
			//----------------------
			int data = (int)cur.data;
			System.out.println(data + "->");
			cur = cur.next;
			//----------------------
		}
		System.out.println();
	}
	
	//�˻�
	public Node Select(Object key) {

		Node cur = head;
		while(cur != null) {
			int data = (int)cur.data;
			if(data == (int)key) {
				return cur;
			}
			cur = cur.next;
		}
		return null;
	}


	
}
