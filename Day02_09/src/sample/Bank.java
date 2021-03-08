package sample;

public class Bank {
	
	private BitArray acciolist = new BitArray(100);
	//�̱��� ���� �ڵ� ---------------------------------
	private Bank() {
		 arr = new BitArray(InputMax());
	}
	//�ڽ��� static ��ü ����
	private static Bank Singleton = new Bank();
	
	//���������� ������ �ڽ��� ��ü�� �ܺο� ���� �ż��� �ʿ�
	public static Bank getInstance() {
		return Singleton;
	}
	//---------------------------------------------
	private BitArray arr;
	
	public int InputMax() {
		return Global.InputNumber("���� ������ �Է��Ͻÿ�.  :");
	}
	
	//��� �޼���
	public void PrintAll() {
		//1. ���� ���� ���
		//2. ��ü ������ ������ ���[�迭 �˰���] - ��ü ��ȸ
		System.out.println("[���尳��] : "+ arr.getSize()+ "��");
		for(int i=0;i<arr.getSize();i++) {
			Account ac = (Account)arr.getData(i);//Down Casting --> instanseof
			ac.Print();
		}
		
	}
	
	//�ߺ��Ǵ� ���� Ȯ��
	private boolean IsAccNumberCheck(int number) {
		for(int i=0;i<arr.getSize();++i) {
			Account ac = (Account)arr.getData(i);
			if(ac.getAccid() == number)
				return false;
		}
		return true;
	}
	
	//�ŷ� ����Ʈ ���� �Լ�
	
	private void InsertAccountIO(int number, int input, int output, int balance) {
		try {
			AccountIO io = new AccountIO(number, input, output, balance);
			acciolist.Insert(io);
		}
		catch(Exception ex){
			System.out.println("�ŷ� ���� ���忡��" + ex.getMessage());
		}
	}
	
	//�ŷ� ����Ʈ ���� ��ȯ
	private int getAccountIOCount(int accnumber) {
		int sum = 0;
		for(int i=0;i<acciolist.getSize();i++) {
			AccountIO accio = (AccountIO)acciolist.getData(i);
			if(accio.getAccNum() == accnumber)
				sum++;
		}
		return sum;
	}
	
	//�ŷ� ����Ʈ ��� �Լ�
	private void PrintAccountIO(int accnumber) {
		System.out.println("[���� ����]" + getAccountIOCount(accnumber)+"��");
		for(int i=0;i<acciolist.getSize();i++) {
			AccountIO accio = (AccountIO)acciolist.getData(i);
			if(accio.getAccNum() == accnumber)
				accio.Print();
		}
	}
	
	public void MakeAccount() {
		try {
		//1. ���� ����  [IN] [OUT]
		//2. �ʱ�ȭ (IN ������ �ʱ�ȭ�� ���, OUT ������ �⺻ �ʱ�ȭ)
		int accid = Global.InputNumber("���¹�ȣ�� �Է��ϼ���.");
		if(!IsAccNumberCheck(accid))
			throw new Exception("�̹� ���°� �����մϴ�.");
		String name = Global.InputString("�̸��� �Է��ϼ���.");
		int balance = Global.InputNumber("�� �Ա��� �ݾ��� �Է��ϼ���.");
		
		//3. ����(���꿡 ���Ǵ� ���� : IN, ���꿡 ����� : OUT)
		Account ac = new Account(accid,name,balance);
		arr.Insert(ac);
		
		InsertAccountIO(accid, balance, 0, balance);
		//4. ��� ���
		System.out.println("���� ����!");
		}
		catch(Exception ex) {
			System.out.println("���� ���� " + ex.getMessage());	
		}
	}

	//�˻� �˰���(���� �˻�)
	//ȸ�� ��ȣ�� ���� --> �迭�� idx ��ȯ(���� : -1)
	private int NumberToIdx(int number) {
		for(int i=0;i<arr.getSize();i++) {
			Account ac = (Account)arr.getData(i);
			if(ac.getAccid() == number)
				return i;
		}
		return -1;
	}

	
	public void SelectAccount() {
		//1. ���� ����[IN]ȸ����ȣ [OUT]
		//2. �ʱ�ȭ (IN ������ �ʱ�ȭ�� ���(ȸ����ȣ <- ����� �Է�), OUT ������ �⺻ �ʱ�ȭ)
		//3. ���� (IN : ���꿡 ���Ǵ� ����, ������ ����� : OUT)
		
		int accid = Global.InputNumber("���� ��ȣ�� �Է��ϼ���");
		int idx = NumberToIdx(accid);
		if(idx != -1) {
			Account ac = (Account)arr.getData(idx);
			ac.Println();
			System.out.println("\n[�ŷ�����Ʈ]");
			PrintAccountIO(accid);
		}
		else
			System.out.println("�����ϴ�.\n");
	}
	
	public void InputMoney() {
		try {
			int accid = Global.InputNumber("�Ա��Ͻ� ���¹�ȣ�� �Է��ϼ���.");
			int money = Global.InputNumber("�Ա��� �ݾ��� �����ϼ���");
			int idx = NumberToIdx(accid);
			if(idx<0)
				throw new Exception("�ش� ���¹�ȣ�� �����ϴ�.");
			Account ac = (Account)arr.getData(idx);
			ac.InputMoney(money);
			InsertAccountIO(accid, money, 0, ac.getBalance()); 
		}
		catch (Exception ex)
		{
			System.out.println("[���� ����]"+ex.getMessage());
		}
		
	}
	
	public void OutputMoney() {
		try {
			int accid = Global.InputNumber("����Ͻ� ���¹�ȣ�� �Է��ϼ���.");
			int money = Global.InputNumber("����� �ݾ��� �����ϼ���");
			int idx = NumberToIdx(accid);
			if(idx<0)
				throw new Exception("�ش� ���¹�ȣ�� �����ϴ�.");
			Account ac = (Account)arr.getData(idx);
			ac.OutputMoney(money);
			InsertAccountIO(accid, 0, money,ac.getBalance());
			System.out.println(money + "�� �� ��ݵǾ����ϴ�.");
		}
		catch (Exception ex)
		{
			System.out.println("[���� ����]"+ex.getMessage());
		}
		
	}
	
	
	public void DeleteAccount() {
		try {
			int number = Global.InputNumber("���� ��ȣ�� �Է��ϼ���");
			int idx = NumberToIdx(number);
			if(idx == -1) 
				throw new Exception("���� ��ȣ�Դϴ�.");
			arr.Delete(idx);
			System.out.println("�����Ǿ����ϴ�.");
		}catch(Exception ex) {
			System.out.println("���� ���� :" +ex.getMessage());
		}
		
	}
}

