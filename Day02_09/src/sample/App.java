package sample;


//실행의 흐름을 담당

public class App {
	
	//생성자
	//싱글톤 패턴 코드 ---------------------------------
	private App() {
		Init();
	}
	//자신의 static 객체 생성
	private static App Singleton = new App();
	
	//내부적으로 생성된 자신의 객체를 외부에 노출 매서드 필요
	public static App getInstance() {
		return Singleton;
	}
	
	//----------------------------------------------
	
	private Bank man = Bank.getInstance();
	
	//매서드
	//초기화 영역
	public void Init() {
		Global.Logo();
	}
	
	//반복적 실행 - 엔진()
	public void Run() {
		while(true) {
			man.PrintAll();
			switch(Global.MenuPrint()) {
			case '0' : return;
			case '1' : man.MakeAccount();break;
			case '2' : man.SelectAccount();break;
			case '3' : man.InputMoney(); break;
			case '4' : man.OutputMoney();break;
			case '5' : man.DeleteAccount();break;
			}
			Global.Pause();
		}
	}
	
	//프로그램 종료 
	public  void Exit() {
		Global.Ending();
	}
}
