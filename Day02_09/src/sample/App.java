package sample;


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
	
	private Bank man = Bank.getInstance();
	
	//�ż���
	//�ʱ�ȭ ����
	public void Init() {
		Global.Logo();
	}
	
	//�ݺ��� ���� - ����()
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
	
	//���α׷� ���� 
	public  void Exit() {
		Global.Ending();
	}
}
