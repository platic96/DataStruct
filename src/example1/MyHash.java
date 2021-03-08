package example1;

enum STATE{
	DELETE,
	EMPTY 
}

public class MyHash {
	//맴버 필드
	private Object[] arr;	//배열 생성시 max값보다 120%크기로 만들겠다.
	private int bucket_max; //배열의 실제 크기[배열을 생성할 때, 해쉬 함수내부에서, 원형이동]
	private int max;		//저장의 최대 크기[Overflow 조건 검사]
	private int size;		//현재 저장된 갯수
	
	//생성자
	public MyHash(int max) {
		this.max = max;
		this.size = 0;
		this.bucket_max = (int)(max*1.2);
		
		//배열 생성 및 초기화!
		arr = new Object[bucket_max];
		for(int i=0; i< arr.length; i++)
			arr[i] = -1;
	}
	
	//get & set 메서드
	public Object getData(int idx) {
		return arr[idx];
	}
	
	//기능 메서드
	/*
	 * 0. 중복값 체크
	 * 1. 오버플로우 조건 검사(정적 구조)
	 * 2. 해쉬 값 획득(해쉬 함수를 활용)
	 * 3. 저장 알고리즘
	 *    빈공간이나 or 삭제된 공간을 찾아(반복문, 시작점: 해쉬값의 위치부터)
	 *     - 이동시 원형이동 필요! 
	 *    찾은 공간의 위치에 저장
	 *    size 증가
	 */
	private boolean IsOverflow() {
		if( max <= size)
			return true;
		else
			return false;
	}
	
	private boolean IsUniq(Object key) {
		for(int i=0; i<arr.length; i++) {
			if( (int)arr[i] == (int)key)
				return false;
		}
		return true;
	}
	
	public boolean Insert(Object key) {
		if(IsUniq(key) == false)
			return false;
		
		if(IsOverflow() == true)
			return false;
		
		int hvalue = HashFunction(key);
		
		while((int)arr[hvalue] != -1 && (int)arr[hvalue] != -2)
			hvalue = (hvalue+1)% bucket_max;
		
		arr[hvalue] = key;
		size++;
		
		return true;
	}
	
	/*
	 * 1. 해쉬값 얻는다(해쉬 테이블)
	 * 2. 반복문활용검색([해쉬값, 해당버킷이 비어있을때(-1)], 원형이동!
	 *    if(저장된 값과 키값을 비교)
	 * [결과값] 버킷의 인덱스 반환(실패시 -1)   
	 */
	public int Select(Object key) {
		int hvalue = HashFunction(key);
		for(int i = hvalue; (int)arr[i] != -1; i = (i+1)%bucket_max) {
			if( (int)arr[i] == (int)key)
				return i;
		}			
		return -1;
	}
	
	/*
	 * 1. key값이 저장된 버켓의 인덱스 값을 획득(Select활용)
	 * 2.1 없는경우(Select의 반환값이 -1)  return false
	 * 2.2 찾은 경우
	 *     해당 버켓의 값을 -2로 저장
	 *     size감소
	 *     return true     
	 */
	public boolean Delete(Object key) {
		int idx = Select(key);
		if( idx == -1)
			return false;
		
		arr[idx] = -2;
		size--;			
		return true;
	}
	
	public void Clear() {
		this.size = 0;
		
		for(int i=0; i< arr.length; i++)
			arr[i] = -1;
	}
	
	public void PrintAll() {
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i< arr.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
	}
	
	//해쉬 함수
	private int HashFunction(Object key) {	
		return ((int)key % bucket_max);
	}	
}
