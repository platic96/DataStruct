
public class Manager {

	//�̱��� ���� �ڵ� ---------------------------------
	private Manager() {
		arr = new BitArray(InputMax());
	}
	//�ڽ��� static ��ü ����
	private static Manager Singleton = new Manager();
	
	//���������� ������ �ڽ��� ��ü�� �ܺο� ���� �ż��� �ʿ�
	public static Manager getInstance() {
		return Singleton;
	}
	//---------------------------------------------
	private BitArray arr;
	
	//�޼���
	public int InputMax() {
		return BitGloval.InputNumber("���� ���� :");
	}
	
	//��� �޼���
	public void SelectAll() {
		//1. ���� ���� ���
		//2. ��ü ������ ������ ���[�迭 �˰���] - ��ü ��ȸ
		System.out.println("[���尳��] : "+ arr.getSize()+ "��");
		for(int i=0;i<arr.getSize();i++) {
			Member mem = (Member)arr.getData(i);//Down Casting --> instanseof
			mem.Print();
		}
		
	}
	
	public void Insert() {
		try {
		//1. ���� ����  [IN] [OUT]
		//2. �ʱ�ȭ (IN ������ �ʱ�ȭ�� ���, OUT ������ �⺻ �ʱ�ȭ)
		
		int number = BitGloval.InputNumber("ȸ�� ��ȣ : ");
		String name = BitGloval.InputString("�̸� : ");
		String phone = BitGloval.InputString("��ȭ ��ȣ : ");
		char gender = BitGloval.InputChar("���� : ");
		
		//3. ����(���꿡 ���Ǵ� ���� : IN, ���꿡 ����� : OUT)
		Member mem = new Member(number, name, phone, gender);
		arr.Insert(mem);
		
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
			Member mem = (Member)arr.getData(i);
			if(mem.getNumber() == number)
				return i;
		}
		return -1;
	}
	
	//ȸ���� �̸��� ���� --> ȸ���� ��ȯ(���� : ���� �߻�)
	private Member NameToMember(String name)  throws Exception {
		for(int i=0;i<arr.getSize();i++) {
			Member mem = (Member)arr.getData(i);
			if(mem.getName().equals(name) ) {
				return mem;
			}
		}
		throw new Exception("���� ȸ���Դϴ�.");
	}
	
	public void Select() {
		//1. ���� ����[IN]ȸ����ȣ [OUT]
		//2. �ʱ�ȭ (IN ������ �ʱ�ȭ�� ���(ȸ����ȣ <- ����� �Է�), OUT ������ �⺻ �ʱ�ȭ)
		//3. ���� (IN : ���꿡 ���Ǵ� ����, ������ ����� : OUT)
		
		int number = BitGloval.InputNumber("ȸ�� ��ȣ�� �Է��ϼ���");
		int idx = NumberToIdx(number);
		if(idx != -1) {
			Member mem = (Member)arr.getData(idx);
			mem.Println();
		}
		else
			System.out.println("�����ϴ�.\n");
	}
	
	public void Update() {
		try {

			String name = BitGloval.InputString("ȸ�� �̸� �Է� :");
			String change_number = BitGloval.InputString("������ ��ȭ��ȣ");
			Member mem = NameToMember(name);
			mem.setPhone(change_number);
			System.out.println("���� ����");
		}
		catch (Exception ex)
		{
			System.out.println("[���� ����]"+ex.getMessage());
		}
		
	}
	
	public void Delete() {
		try {
			int number = BitGloval.InputNumber("ȸ�� ��ȣ�� �Է��ϼ���");
			int idx = NumberToIdx(number);
			if(idx == -1) 
				throw new Exception("���� ȸ�� ��ȣ�Դϴ�.");
			arr.Delete(idx);
			System.out.println("�����Ǿ����ϴ�.");
		}catch(Exception ex) {
			System.out.println("���� ���� :" +ex.getMessage());
		}
		
	}
}
