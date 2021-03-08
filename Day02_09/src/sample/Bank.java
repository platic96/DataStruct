package sample;

public class Bank {
	
	private BitArray acciolist = new BitArray(100);
	//싱글톤 패턴 코드 ---------------------------------
	private Bank() {
		 arr = new BitArray(InputMax());
	}
	//자신의 static 객체 생성
	private static Bank Singleton = new Bank();
	
	//내부적으로 생성된 자신의 객체를 외부에 노출 매서드 필요
	public static Bank getInstance() {
		return Singleton;
	}
	//---------------------------------------------
	private BitArray arr;
	
	public int InputMax() {
		return Global.InputNumber("저장 공간을 입력하시요.  :");
	}
	
	//기능 메서드
	public void PrintAll() {
		//1. 저장 개수 출력
		//2. 전체 데이터 정보를 출력[배열 알고리즘] - 전체 순회
		System.out.println("[저장개수] : "+ arr.getSize()+ "개");
		for(int i=0;i<arr.getSize();i++) {
			Account ac = (Account)arr.getData(i);//Down Casting --> instanseof
			ac.Print();
		}
		
	}
	
	//중복되는 계좌 확인
	private boolean IsAccNumberCheck(int number) {
		for(int i=0;i<arr.getSize();++i) {
			Account ac = (Account)arr.getData(i);
			if(ac.getAccid() == number)
				return false;
		}
		return true;
	}
	
	//거래 리스트 저장 함수
	
	private void InsertAccountIO(int number, int input, int output, int balance) {
		try {
			AccountIO io = new AccountIO(number, input, output, balance);
			acciolist.Insert(io);
		}
		catch(Exception ex){
			System.out.println("거래 내역 저장에러" + ex.getMessage());
		}
	}
	
	//거래 리스트 개수 반환
	private int getAccountIOCount(int accnumber) {
		int sum = 0;
		for(int i=0;i<acciolist.getSize();i++) {
			AccountIO accio = (AccountIO)acciolist.getData(i);
			if(accio.getAccNum() == accnumber)
				sum++;
		}
		return sum;
	}
	
	//거래 리스트 출력 함수
	private void PrintAccountIO(int accnumber) {
		System.out.println("[저장 개수]" + getAccountIOCount(accnumber)+"개");
		for(int i=0;i<acciolist.getSize();i++) {
			AccountIO accio = (AccountIO)acciolist.getData(i);
			if(accio.getAccNum() == accnumber)
				accio.Print();
		}
	}
	
	public void MakeAccount() {
		try {
		//1. 변수 선언  [IN] [OUT]
		//2. 초기화 (IN 변수는 초기화의 대상, OUT 변수는 기본 초기화)
		int accid = Global.InputNumber("계좌번호를 입력하세요.");
		if(!IsAccNumberCheck(accid))
			throw new Exception("이미 계좌가 존재합니다.");
		String name = Global.InputString("이름을 입력하세요.");
		int balance = Global.InputNumber("선 입금할 금액을 입력하세요.");
		
		//3. 연산(연산에 사용되는 변수 : IN, 연산에 결과값 : OUT)
		Account ac = new Account(accid,name,balance);
		arr.Insert(ac);
		
		InsertAccountIO(accid, balance, 0, balance);
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
			Account ac = (Account)arr.getData(i);
			if(ac.getAccid() == number)
				return i;
		}
		return -1;
	}

	
	public void SelectAccount() {
		//1. 변수 선언[IN]회원번호 [OUT]
		//2. 초기화 (IN 변수는 초기화의 대상(회원번호 <- 사용자 입력), OUT 변수는 기본 초기화)
		//3. 연산 (IN : 연산에 사용되는 변수, 연산의 결과값 : OUT)
		
		int accid = Global.InputNumber("계좌 번호를 입력하세요");
		int idx = NumberToIdx(accid);
		if(idx != -1) {
			Account ac = (Account)arr.getData(idx);
			ac.Println();
			System.out.println("\n[거래리스트]");
			PrintAccountIO(accid);
		}
		else
			System.out.println("없습니다.\n");
	}
	
	public void InputMoney() {
		try {
			int accid = Global.InputNumber("입금하실 계좌번호를 입력하세요.");
			int money = Global.InputNumber("입금할 금액을 선택하세요");
			int idx = NumberToIdx(accid);
			if(idx<0)
				throw new Exception("해당 계좌번호가 없습니다.");
			Account ac = (Account)arr.getData(idx);
			ac.InputMoney(money);
			InsertAccountIO(accid, money, 0, ac.getBalance()); 
		}
		catch (Exception ex)
		{
			System.out.println("[수정 오류]"+ex.getMessage());
		}
		
	}
	
	public void OutputMoney() {
		try {
			int accid = Global.InputNumber("출금하실 계좌번호를 입력하세요.");
			int money = Global.InputNumber("출금할 금액을 선택하세요");
			int idx = NumberToIdx(accid);
			if(idx<0)
				throw new Exception("해당 계좌번호가 없습니다.");
			Account ac = (Account)arr.getData(idx);
			ac.OutputMoney(money);
			InsertAccountIO(accid, 0, money,ac.getBalance());
			System.out.println(money + "원 이 출금되었습니다.");
		}
		catch (Exception ex)
		{
			System.out.println("[수정 오류]"+ex.getMessage());
		}
		
	}
	
	
	public void DeleteAccount() {
		try {
			int number = Global.InputNumber("계좌 번호를 입력하세요");
			int idx = NumberToIdx(number);
			if(idx == -1) 
				throw new Exception("없는 번호입니다.");
			arr.Delete(idx);
			System.out.println("삭제되었습니다.");
		}catch(Exception ex) {
			System.out.println("삭제 에러 :" +ex.getMessage());
		}
		
	}
}

