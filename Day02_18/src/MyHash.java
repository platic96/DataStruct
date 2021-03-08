
public class MyHash {
	//멤버 필드
	private Object[] arr;	//배열 생성시 max값 보다 120% 크기로 생성.
	private int max; 		//저장의 최대 크기
	private int size; 		// 현재 저장된 데이터의 갯수
	private int empty= -1;
	private int delete = -2;
	private int hashsize;
	
	//생성자
	public MyHash(int _max) {
		this.max = _max;
		size = 0;
		hashsize = (int)(_max*1.2);
		arr = new Object[hashsize];
		for(int i=0;i<hashsize;i++)
			arr[i] = this.empty;
	}
	
	//get & set
	
	//메서드
	/*
	 * 1. 오버플로우 검사 (정적 구조)
	 * 2. 해쉬 값 획득(해쉬함수 사용)
	 * 3. 저장 알고리즘
	 * 	3.1 빈공간 또는 삭제된 공간을 찾아 저장(반복문, 시작점 : 해쉬값의 위치부터)
	 * 	3.2 찾은 공간의 위치에 저장
	 * 	3.3 size 저장
	 */
	
	//오버플로우 검사함수
	private boolean IsOverflow() {
		if(size >= max)
			return true;
		else
			return false;
	}
	
	//배열이 비어있는지 삭제되었는지 판단하는 함수
	private boolean IsEmptyOrDelete(int idx) {
		if((int)arr[idx] == empty || (int)arr[idx] == delete)
			return true;
		else
			return false;
	}
	
	//중복 값 체크
	private boolean IsUniq(Object key) {
		for(int i=0;i<arr.length;i++)
			if((int)arr[i] == (int)key)
				return false;
		return true;
	}
	
	//삽입함수.
	public boolean Insert(Object data) {
		if(IsOverflow()==true)
			return false;
		if(IsUniq(data)== false)
			return false;
		int idx = HashFunction(data);
		while(!IsEmptyOrDelete(idx) ) 
			idx= (idx+1)%hashsize;
		arr[idx] = data;
		size++;
		return true;
	}
	
	/*
	 * 1. 해쉬값은 얻는다
	 * 2. 반복문활용검색([해쉬값,해당버킷이 비어있을때])
	 * 	if(저장된 값과 키 값을 비교)
	 * [결과값] 버킷의 인덱스 반환(실패시 -1)
	 * 
	 */
	public int Select(Object key) {
		int idx = HashFunction(key);
		while((int)arr[idx]!= empty) {
			if((int)arr[idx] == (int)key)
				return idx;
			else
				idx = (idx+1)%hashsize;
		}
		return -1;
	}
	
	/*
	 * 1. key값이 저장된 버킷의 인덱스 값을 획득(Select활용)
	 * 2. 없는경우(Select의 반환값이 -1) return false
	 * 2. 찾은경우
	 * 	해당 버킷의 값을 -2로 저장
	 * 	size 감소
	 * 	return true;
	 */
	public boolean Delete(Object key) {
		int idx = Select(key);
		if(idx == -1)
			return false;
		arr[idx] = delete;
		size--;
		return true;
	}
	
	public void Clear() {
		this.size = 0;
		
		for(int i=0;i<arr.length;i++)
			arr[i]=-1;
	}
	
	//출력함수
	public void PrintAll() {
		System.out.println("-------------------------------------------------------------------------------");
		for(int i=0;i<arr.length;i++)
			System.out.print(i+"\t");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+"\t");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	//해쉬 함수
	public int HashFunction(Object key) {
		return (int)key%hashsize;
	}

	public Object getData(int idx) {
		// TODO Auto-generated method stub
		return arr[idx];
	}
}
