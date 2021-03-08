//package example;
//
////pair형태로 관리할 데이터 타입!
//
//class PairData{
//	int key;
//	Member mem;
//	
//	public PairData(Member mem) {
//		this.key = mem.getNumber();
//		this.mem = mem;
//	}w
//}
//
//
///*
// * 저장 공간의 일관성
// * 자바 Collection 클래스
// * 1. Object 저장
// * 2. Templete 저장 클래스
// * 
// * => object를 저장하는 형태로 수정!!!!!! null(비어있을 때)
// */
//public class MyHashMap {
//	//멤버 필드
//	private Object[] arr;	//배열 생성시 max값 보다 120% 크기로 생성.
//	private int max; 		//저장의 최대 크기
//	private int size; 		// 현재 저장된 데이터의 갯수
//	private int empty= -1;
//	private int delete = -2;
//	private int hashsize;
//	
//	//생성자
//	public MyHashMap(int _max) {
//		this.max = _max;
//		size = 0;
//		hashsize = (int)(_max*1.2);
//		arr = new Object[hashsize];
//		for(int i=0;i<hashsize;i++)
//			arr[i] = null;
//	}
//	
//	//get & set
//	
//	//메서드
//	/*
//	 * 1. 오버플로우 검사 (정적 구조)
//	 * 2. 해쉬 값 획득(해쉬함수 사용)
//	 * 3. 저장 알고리즘
//	 * 	3.1 빈공간 또는 삭제된 공간을 찾아 저장(반복문, 시작점 : 해쉬값의 위치부터)
//	 * 	3.2 찾은 공간의 위치에 저장
//	 * 	3.3 size 저장
//	 */
//	
//	//오버플로우 검사함수
//	private boolean IsOverflow() {
//		if(size >= max)
//			return true;
//		else
//			return false;
//	}
//	
//	//중복 값 체크
//	private boolean IsUniq(Object key) {
//		for(int i=0;i<arr.length;i++) {
//				Member mem = (Member)arr[i];
//				if(mem != null && mem.getNumber() == (int)key)
//					return false;	
//		}
//		return true;
//	}
//	
//	//삽입함수.
//	public boolean Insert(int key, Object data) {
//		if(IsOverflow()==true)
//			return false;
//		if(IsUniq(key)== false)
//			return false;
//		int idx = HashFunction(key);
//		while(arr[idx] != null && ((Member)arr[idx]).getNumber() != delete) 
//			idx= (idx+1)%hashsize;
//		arr[idx] = data;
//		size++;
//		return true;
//	}
//	
//	/*
//	 * 1. 해쉬값은 얻는다
//	 * 2. 반복문활용검색([해쉬값,해당버킷이 비어있을때])
//	 * 	if(저장된 값과 키 값을 비교)
//	 * [결과값] 버킷의 인덱스 반환(실패시 -1)
//	 * 
//	 */
//	public int Select(Object key) {
//		int idx = HashFunction(key);
//		while(arr[idx] == null) {
//			if((int)arr[idx] == (int)key)
//				return idx;
//			else
//				idx = (idx+1)%hashsize;
//		}
//		return -1;
//	}
//	
//	/*
//	 * 1. key값이 저장된 버킷의 인덱스 값을 획득(Select활용)
//	 * 2. 없는경우(Select의 반환값이 -1) return false
//	 * 2. 찾은경우
//	 * 	해당 버킷의 값을 -2로 저장
//	 * 	size 감소
//	 * 	return true;
//	 */
//	public boolean Delete(Object key) {
//		int idx = Select(key);
//		if(idx == -1)
//			return false;
//		((Member)arr[idx]).setNumber(delete);
//		size--;
//		return true;
//	}
//	
//	public void Clear() {
//		this.size = 0;
//		
//		for(int i=0;i<arr.length;i++)
//			arr[i]=null;
//	}
//	
//	//출력함수
//	public void PrintAll() {
//		System.out.println("-------------------------------------------------------------------------------");
//		for(int i=0;i<arr.length;i++)
//			System.out.print(i+"\t");
//		System.out.println();
//		System.out.println("-------------------------------------------------------------------------------");
//		for(int i=0;i<arr.length;i++)
//			if(arr[i] == null)
//				System.out.println("-1" + "\t");
//			else
//				System.out.print(((Member)arr[i]).getNumber()+"\t");
//			
//		System.out.println();
//		System.out.println("-------------------------------------------------------------------------------");
//	}
//	
//	//해쉬 함수
//	public int HashFunction(Object key) {
//		return (int)key%hashsize;
//	}
//
//	public Object getData(int idx) {
//		// TODO Auto-generated method stub
//		return arr[idx];
//	}
//
//	public Object KeyToValue(int number) {
//		int idx = Select(number);
//		if(idx == -1 )
//			return null;
//		return arr[idx];
//	}
//}

package example	;

/*
 * MAP :pair형태의 저장자료구조 
 *      [KEY, VALUE]
 *      KEY : 검색에 활용!, 중복허용안됨!
 *      VALUE : 저장데이터, 중복허용
 */

//Pair형태로 관리할 데이터 타입!
class PairData{
	int key;	//회원번호
	Member mem; //저장값
	
	public PairData(Member mem) {
		this.key = mem.getNumber();
		this.mem = mem;
	}
}

/*
 * 저장 공간의 일관성
 * 자바 Collection 클래스
 * 1.  Object 저장(초기에는 JDK에 템플릿 문법 X)
 *      하나의 저장소에 정수, 객체 섞어서 저장해도 저장이 가능! 문제점.
 * 2.  템플릿 기반 저장( JDK 1.2?)
 * 
 * ==> Object를 저장하는 형태로 수정!!!!!!!! null(비어있을 때)
 */
public class MyHashMap {
	//맴버 필드
	private Object[] arr;	//배열 생성시 max값보다 120%크기로 만들겠다.
	private int bucket_max; //배열의 실제 크기[배열을 생성할 때, 해쉬 함수내부에서, 원형이동]
	private int max;		//저장의 최대 크기[Overflow 조건 검사]
	private int size;		//현재 저장된 갯수
	
	//생성자
	public MyHashMap(int max) {
		this.max = max;
		this.size = 0;
		this.bucket_max = (int)(max*1.2);
		
		//배열 생성 및 초기화!
		arr = new Object[bucket_max];
		for(int i=0; i< arr.length; i++)
			arr[i] = null; //<========================= -1 -> null (수정1)
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
				Member mem = (Member)arr[i];	
				if(mem != null && mem.getNumber() == (int)key)  //<------(수정2)
					return false;
		}
		return true;		
	}
	
	public boolean Insert(int key, Object value) {
		if(IsUniq(key) == false)
			return false;
		
		if(IsOverflow() == true)
			return false;
		
		int hvalue = HashFunction(key);
		
		//while((int)arr[hvalue] != -1 && (int)arr[hvalue] != -2)
		while(arr[hvalue] != null && ((Member)arr[hvalue]).getNumber()!=-2)	//<============================수정3)
			hvalue = (hvalue+1)% bucket_max;
		
		arr[hvalue] = value;  //<-------------------------------
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

		for(int i = hvalue; arr[i] != null; i = (i+1)%bucket_max) {
			Member mem = (Member)arr[i];	
			if( mem!= null && mem.getNumber() == (int)key)  //<========= 4)수정
				return i;
		}			
		return -1;
	}
	
	public Object KeyToValue(int key) {
		int idx = Select(key);
		if( idx == -1)
			return null;
		
		return arr[idx];
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
		
		((Member)arr[idx]).setNumber(-2);		//<==================== 수정2)
		size--;			
		return true;
	}
	
	public void Clear() {
		this.size = 0;
		
		for(int i=0; i< arr.length; i++)
			arr[i] = null;						//<========================== 수정
	}
	
	public void PrintAll() {
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i< arr.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i< arr.length; i++) {
			if( arr[i] == null)								//<======= null비교
				System.out.print("-1" + "\t");
			else
				System.out.print(((Member)arr[i]).getNumber() + "\t");				
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
	}
	
	//해쉬 함수
	private int HashFunction(Object key) {	
		return ((int)key % bucket_max);
	}	
}
