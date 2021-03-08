//MyList.java

public class MyList {
	private Node head;
	private int size;
	
	public MyList() {
		this.head = null;
		this.size = 0;
	}
	
	//연결 ----------------------------------
	//1. 노드생성(초기화), 2. 연결 알고리즘
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
	
	//꼬리 노드에 생성
	public boolean back_Insert(Object data) {
		Node newnode = new Node(data);
		
		if(head == null)
			head = newnode;
		else {
			//꼬리를 찾는 과정
			Node cur = head;
			while(cur.next != null) {
				cur = cur.next;
			}
			//연결
			cur.next = newnode;
		}
		size++;
		return true;
	}
	
	// cur의 다음 노드에 연결 내가짠 소스라 완벽할지 모름 조심.
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
	
	//삭제 ----------------------------------
	//1. 삭제할 노드를 찾는다. 2. 삭제 알고리즘
	public boolean front_delete() {
		Node del = head;
		
		if(del == null) //노드가 없을때
			return false;
		head = del.next;
		size--;
		return true;
	}

	//1. 삭제할 노드와(이전노드)를 찾는다. 2. 삭제 알고리즘
	public boolean back_delete() {
		Node del = head;
		Node prev = head;
		
		if(del == null) //노드가 없는 상태
			return false;
		
		if( del.next == null) { //노드가 하나인 상황
			head = null;
		}
		else {  //노드가 두개 이상인 상황
			while( del.next != null) {
			    prev = del;
			    del = del.next;
			}
			prev.next = null;
		}
		size--;
		return false;
		
	}
	
	
	//cur의 다음 노드를 삭제!
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

	//순회 ----------------------------------
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
	
	//검색
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
