package example1;

public class MyLinkedStack {
	private MyDList list;
	
	public MyLinkedStack() {
		list = new MyDList();
	}
	
	public boolean Push(Object obj) {
		return list.push_front(obj);
	}
	public boolean IsEmpty() {
		MyDList.DNode node = list.getHead();
		if(node == null)
			return true;
		else
			return false;
	}
	
	public Object Pop() {
		if(IsEmpty())
			return null;
		Object data = list.getHead().data;
		list.erase_front();
		return data;
	}
	
	public void PrintAll() {
		list.Select_PrevAll();
	}
	
	public Object GetTop() throws Exception{
		if(IsEmpty())
			throw new Exception("비어있다.");
		Object data = list.getHead().data;
		return data;
	}
}
