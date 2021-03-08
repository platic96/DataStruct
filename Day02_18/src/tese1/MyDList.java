package tese1;

//DNode�� MyDList������ ���Ǵ� ���� Ŭ����!
public class MyDList {
	public class DNode {
		Object data;	//����
		DNode prev;		//����
		DNode next;		//����
		
		public DNode(Object data) {
			this.data = data;
			this.prev= null;
			this.next = null;
		}
	}

	
	private DNode tail;
	private DNode head;
	int size;
	
	public MyDList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
//	public boolean Clear() {
//
//	}
	
	//insert
	public boolean push_front(Object data) {
		DNode newnode = new DNode(data);
		
		if(this.head == null && this.tail ==null) {
			head = newnode;
			tail = newnode;
		}
		else {
			newnode.next = head;
			head.prev = newnode;
			head = newnode;
		}
		size++;
		return true;
	}
	
	public boolean push_back(Object data) {

		DNode newnode = new DNode(data);
		
		if(this.head == null && this.tail ==null) {
			head = newnode;
			tail = newnode;
		}
		else {
			newnode.prev = tail;
			tail.next = newnode;
			tail = newnode;
		}
		size++;
		return true;
	}
	
	//select all
	public void Select_NextAll() {
		System.out.println("["+ size+"]");
		DNode cur = head;
		
		while(cur != null) {
			//----------------------
			int data = (int)cur.data;
			System.out.println(data + "->");
			cur = cur.next;
			//----------------------
		}
		System.out.println();
	}
	
	public void Select_PrevAll() {
		System.out.println("["+ size+"]");
		DNode cur = tail;
		
		while(cur != null) {
			//----------------------
			int data = (int)cur.data;
			System.out.println(data + "<-");
			cur = cur.prev;
			//----------------------
		}
		System.out.println();
	}
	
	//�˻�
	public DNode Select(Object key) {
		DNode cur = head;
		while(cur != null) {
			int data = (int)cur.data;
			if(data == (int)key) {
				return cur;
			}
			cur = cur.next;
		}
		return null;
	}

	public boolean push_random(DNode cur, Object data) {
		DNode newnode = new DNode(data);
		
		if(cur == tail) {
//			newnode.prev = tail;
//			tail.next = newnode;
//			tail = newnode;
			return push_back(data);
		}
		else {
			newnode.prev = cur;
			newnode.next = cur.next;
			cur.next.prev = newnode;
			cur.next = newnode;
		}
		size++;
		return true;
	}

	public boolean erase_front() {
//		if(head == null && tail == null) {
//			return false;
//		}
//		else if(head == tail) {
//			head = null;
//			tail = null;
//		}
//		else {
//			head.next = head.next.next;
//			head.next.next.prev = head;
//		}
			if( head == null) {		//������� ��
				return false;
			}
			else if(head.next == null) { //��尡 �ϳ��λ�Ȳ  tail.prev == null
				head = tail = null;
			}
			else {  //��尡 2�� �̻��� ��Ȳ
				DNode del = head;
				
				head = del.next;
				head.prev = null;		
				
				//del.next.prev = null;
				//head = del.next;
			}
			size--;
			return true;
	}
	
	public boolean erase_back() {
		if(tail == null)
			return false;
		else if(tail.prev == null)
			tail = head = null;
		else {
			DNode delprev = tail.prev;
			
			delprev.next = null;
			tail = delprev;
		}
		size--;
			
		return true;
	}

	public boolean erase_random(DNode del) {
		if(del == null)
			return false;
		else if(del == head)
			return erase_front();
		else if(del == tail)
			return erase_back();
		else {
			del.prev.next = del.next;
			del.next.prev = del.prev;
		}
		size--;
		return true;
	}
	
	public DNode getHead() {
		return this.head;
	}

}
