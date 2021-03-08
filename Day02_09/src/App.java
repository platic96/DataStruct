
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
	
	private Manager man = Manager.getInstance();
	
	//매서드
	//초기화 영역
	public void Init() {
		BitGloval.Logo();
	}
	
	//반복적 실행 - 엔진()
	public void Run() {
		while(true) {
			man.SelectAll();
			switch(BitGloval.MenuPrint()) {
			case '0' : return;
			case '1' : man.Insert();break;
			case '2' : man.Select();break;
			case '3' : man.Update(); break;
			case '4' : man.Delete();break;
			}
			BitGloval.Pause();
		}
	}
	
	//프로그램 종료 
	public  void Exit() {
		BitGloval.Ending();
	}
}
