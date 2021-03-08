package example3;

public class MyLinkedQueue {
	private MyDList list;
	
	public MyLinkedQueue() {
		list = new MyDList();
	}
	
	public boolean Put(Object obj) {
		return list.push_front(obj);
	}
	public boolean IsEmpty() {
		MyDList.DNode node = list.getHead();
		if(node == null)
			return true;
		else
			return false;
	}
	
	public Object Get() {
		if(IsEmpty())
			return null;
		Object data = list.getHead().data;
		list.erase_back();
		return data;
	}
	
	public void PrintAll() {
		list.Select_NextAll();
	}
	
	public Object GetFront() throws Exception{
		if(IsEmpty())
			throw new Exception("비어있다.");
		Object data = list.getHead().data;
		return data;
	}
	public void Clear() {
		list.Clear();
	}
}
