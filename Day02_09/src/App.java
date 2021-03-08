
//������ �帧�� ���

public class App {
	
	//������
	//�̱��� ���� �ڵ� ---------------------------------
	private App() {
		Init();
	}
	//�ڽ��� static ��ü ����
	private static App Singleton = new App();
	
	//���������� ������ �ڽ��� ��ü�� �ܺο� ���� �ż��� �ʿ�
	public static App getInstance() {
		return Singleton;
	}
	
	//----------------------------------------------
	
	private Manager man = Manager.getInstance();
	
	//�ż���
	//�ʱ�ȭ ����
	public void Init() {
		BitGloval.Logo();
	}
	
	//�ݺ��� ���� - ����()
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
	
	//���α׷� ���� 
	public  void Exit() {
		BitGloval.Ending();
	}
}
