
public class BitStack {
	private int max;
	private Object[] arr;
	private int top;
	
	public BitStack() {
		this(5);
	}
	
	public BitStack(int _max) {
		this.top=-1;
		this.max = _max;
		this.arr = new Object[_max];
	}
	
	private boolean IsOverflow() {
		if(max<= top+1) {
			return true;
		}
		else
			return false;
	}
	
	public void Push(Object obj) throws Exception {
		if(IsOverflow()) {
			throw new Exception("오버플로우가 발생했습니다.");
		}
		this.arr[++top] = obj;
	}
	
	public boolean IsEmpty() {
		return top<0;
	}
	
	public Object Pop(){
		if(IsEmpty()) {
			System.out.println("값이 존재하지 않습니다.");
			return null;
		}
		return arr[top--];
	}
	
	public void PrintAll() {
		for(int i=0;i<=top;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public Object GetTop() throws Exception{
		if(top<0) {
			throw new Exception("비어있습니다.");
		}
		return arr[top];
	}
	
	public void Clear() {
		top = -1;
	}

}
