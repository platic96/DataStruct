
public class Manager {

	//싱글톤 패턴 코드 ---------------------------------
	private Manager() {
		arr = new BitArray(InputMax());
	}
	//자신의 static 객체 생성
	private static Manager Singleton = new Manager();
	
	//내부적으로 생성된 자신의 객체를 외부에 노출 매서드 필요
	public static Manager getInstance() {
		return Singleton;
	}
	//---------------------------------------------
	private BitArray arr;
	
	//메서드
	public int InputMax() {
		return BitGloval.InputNumber("저장 개수 :");
	}
	
	//기능 메서드
	public void SelectAll() {
		//1. 저장 개수 출력
		//2. 전체 데이터 정보를 출력[배열 알고리즘] - 전체 순회
		System.out.println("[저장개수] : "+ arr.getSize()+ "개");
		for(int i=0;i<arr.getSize();i++) {
			Member mem = (Member)arr.getData(i);//Down Casting --> instanseof
			mem.Print();
		}
		
	}
	
	public void Insert() {
		try {
		//1. 변수 선언  [IN] [OUT]
		//2. 초기화 (IN 변수는 초기화의 대상, OUT 변수는 기본 초기화)
		
		int number = BitGloval.InputNumber("회원 번호 : ");
		String name = BitGloval.InputString("이름 : ");
		String phone = BitGloval.InputString("전화 번호 : ");
		char gender = BitGloval.InputChar("성별 : ");
		
		//3. 연산(연산에 사용되는 변수 : IN, 연산에 결과값 : OUT)
		Member mem = new Member(number, name, phone, gender);
		arr.Insert(mem);
		
		//4. 결과 출력
		System.out.println("저장 성공!");
		}
		catch(Exception ex) {
			System.out.println("저장 실패 " + ex.getMessage());	
		}
	}

	//검색 알고리즘(순차 검색)
	//회원 번호를 전달 --> 배열의 idx 반환(실패 : -1)
	private int NumberToIdx(int number) {
		for(int i=0;i<arr.getSize();i++) {
			Member mem = (Member)arr.getData(i);
			if(mem.getNumber() == number)
				return i;
		}
		return -1;
	}
	
	//회원의 이름을 전달 --> 회원을 반환(실패 : 예외 발생)
	private Member NameToMember(String name)  throws Exception {
		for(int i=0;i<arr.getSize();i++) {
			Member mem = (Member)arr.getData(i);
			if(mem.getName().equals(name) ) {
				return mem;
			}
		}
		throw new Exception("없는 회원입니다.");
	}
	
	public void Select() {
		//1. 변수 선언[IN]회원번호 [OUT]
		//2. 초기화 (IN 변수는 초기화의 대상(회원번호 <- 사용자 입력), OUT 변수는 기본 초기화)
		//3. 연산 (IN : 연산에 사용되는 변수, 연산의 결과값 : OUT)
		
		int number = BitGloval.InputNumber("회원 번호를 입력하세요");
		int idx = NumberToIdx(number);
		if(idx != -1) {
			Member mem = (Member)arr.getData(idx);
			mem.Println();
		}
		else
			System.out.println("없습니다.\n");
	}
	
	public void Update() {
		try {

			String name = BitGloval.InputString("회원 이름 입력 :");
			String change_number = BitGloval.InputString("변경할 전화번호");
			Member mem = NameToMember(name);
			mem.setPhone(change_number);
			System.out.println("수정 성공");
		}
		catch (Exception ex)
		{
			System.out.println("[수정 오류]"+ex.getMessage());
		}
		
	}
	
	public void Delete() {
		try {
			int number = BitGloval.InputNumber("회원 번호를 입력하세요");
			int idx = NumberToIdx(number);
			if(idx == -1) 
				throw new Exception("없는 회원 번호입니다.");
			arr.Delete(idx);
			System.out.println("삭제되었습니다.");
		}catch(Exception ex) {
			System.out.println("삭제 에러 :" +ex.getMessage());
		}
		
	}
}
