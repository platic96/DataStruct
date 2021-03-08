package sample;

import java.util.Calendar;

public class Account {
	private int accid;
	private String name;
	private int balance;
	private Calendar newtime;
	
	Account(int _accid,String _name,int _balance) {

		setAccid(_accid);
		setName(_name);
		setBalance(_balance);
		setNewtime( Calendar.getInstance());
	}
	
	public Account(int _accid,String _name) {
		this(_accid, _name, 0);
		setNewtime( Calendar.getInstance());
	}
	
	public int getAccid() {
		return accid;
	}

	private void setAccid(int accid) {
		this.accid = accid;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	private void setBalance(int balance) {
		this.balance = balance;
	}

	public Calendar getNewtime() {
		return newtime;
	}

	private void setNewtime(Calendar newtime) {
		this.newtime = newtime;
	}

	//�޼���
	
	public void InputMoney(int money) throws Exception{
		if(money<0)
			throw new Exception("�߸��� �ݾ��Դϴ�.");
		this.balance += money;
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}
	
	public void OutputMoney(int money) throws Exception{
		if(money<0)
			throw new Exception("�߸��� �ݾ��Դϴ�.");
		else if(this.balance <money)
			throw new Exception("���ݵ� �ݾ׺��� ���� �ݾ��Դϴ�.");
		
		this.balance -= money;
		System.out.println("����� �Ϸ�Ǿ����ϴ�.");
	}
	
	public String GetDate() {
		String temp = String.format("%04d-%02d-%02d", 
				newtime.get(Calendar.YEAR) ,newtime.get(Calendar.MONTH), newtime.get(Calendar.DAY_OF_MONTH));
		return temp;
	}
	
	public String GetTime() {
		String temp = String.format("%02d:%02d", 
				newtime.get(Calendar.HOUR_OF_DAY) ,newtime.get(Calendar.MONTH), newtime.get(Calendar.MINUTE));
		return temp;
	}
	
	public void Println() {
		System.out.println("[���¹�ȣ] : "+ accid);
		System.out.println("[�̸�] : "+ name);
		System.out.println("[�ܾ�] : "+ balance);
		System.out.println("[���� ����] : "+ GetDate());
		System.out.println("[���� �ð�] : "+ GetTime());
	}
	
	public void Print() {
		System.out.printf("[%d] %s %d %s \n",accid,name,balance,GetDate()+GetTime());
	}
}
