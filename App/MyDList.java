
public class MyDList {
	
	// inner class ------------------------------------------------------------------------------------
	public class DNode { // DNode가 MyDList에서만 사용되는 전용 클래스
		Object data; // 저장된 데이터
		DNode prev; // 이전 노드
		DNode next; // 다음 노드
		
		public DNode(Object data) {
			this.data= data;
			this.prev = null;
			this.next = null;
		}
		
		public Object getData() {
			return data;
		}
	} // end inner class
	
	// member field ------------------------------------------------------------------------------------
	private DNode head; // 
	private DNode tail;
	private int size;
	
	// Constructor ------------------------------------------------------------------------------------
	public MyDList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// insert method ------------------------------------------------------------------------------------
	public boolean push_front(Object data) { 
		DNode newnode = new DNode(data);  // 노드 생성 및 초기화
		
		if ( this.head == null ) { // DList가 비어 있는 상황 : head == null && tail == null
			this.head = newnode;
			this.tail = newnode;
		}
		else { // 기존 Node가 있는 상황
			newnode.next = this.head;
			head.prev = newnode;
			this.head = newnode;
		}
		size ++;
		return true;
	}
	public boolean push_back(Object data) {
		DNode newnode = new DNode(data);
		
		if (head == null ) { // 기존 노드가 하나도 없을 경우
			head = newnode;
			tail = newnode;
		}
		else {
			newnode.prev = tail;
			tail.next = newnode;
			tail = newnode;
		}
		size ++;
		return true;
	}
	public boolean push_random(DNode cur, Object data) { // cur 다음에 저장
		
		if (cur.next == null) { // 마지막 노드 연결 과정
			return push_back(data);
		}

		// 노드와 노드 중간에 연결하는 상황
		DNode newnode = new DNode(data);

		newnode.prev = cur;
		newnode.next = cur.next;
		cur.next.prev = newnode;
		cur.next = newnode;
		
		size++;		
		return true;
	}
	
	// search method ------------------------------------------------------------------------------------
	public DNode select(Object key) { // 검색(검색 데이터 ---> DNode 반환(실패:null)) 
		DNode cur = head;
		while(cur != null) {
			Object data = cur.data;
			
			if (data instanceof User) {
				User user = (User)data;
				if ( user.getUserId().equals(key)) {
					return cur;
				}
			}
			else {
				if ( data.equals(key)) {
					return cur;
				}
			}
			cur = cur.next;
		}
		return null;
	}

	// traverse  method ------------------------------------------------------------------------------------
	public void selectNextAll() { // head -> tail 
		
		DNode cur = head;
		while(cur != null) {
			Object data = cur.data ;	
			System.out.println(data.toString());
			cur = cur.next;
		}
	}
	
	// delete method ------------------------------------------------------------------------------------
	public boolean erase_front() { // 삭제할 노드를 가리킨다.
		
		if (head == null ) return false;
		else 	if ( head.next == null) {  // head.next == null 또는 tail.prev = null
			head = tail = null;
		} 
		else  {
			DNode del = head;
			head = del.next;
			head.prev = null;
		}
		size --;
		return true;
	}

	public boolean erase_back() {
		if (head == null) return false;
		else if (head.next == null) {
			head = tail = null;
		}
		else {
			DNode delPrev = tail.prev;
			delPrev.next = null;
			tail = delPrev;
		}
		size --;
		return true;
	}
	public boolean erase_random(DNode del) { // 해당 노드를 삭제
		if (del == null ) return false;
		
		if (del.prev == null) { // 노드가 1개
			return erase_front();
		}
		else if(del.next == null) { // 노드가 2개
			return erase_back();
		}
		else { // 노드가 3개 이상
			DNode prev = del.prev;
			prev.next = del.next;
			del.next.prev = prev;
// 		아래 코드도 동일한 작동
//			del.prev.next = del.next;
//			del.next.prev = del.prev;
			size--;
			return true;	
		}
	}
	
	// 초기화
	public void clear() {
		head = tail = null;
		size = 0;
	}

	// Getter ---------------------------------------------------------------------------------------------------
	public DNode getHead() {
		return head;
	}
	
	public int getSize() {
		return this.size;
		
	}
	

}
