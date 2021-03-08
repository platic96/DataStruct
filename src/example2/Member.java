package example2;
//Member.java

//Member ��ü ����(number���� key�� ���!) [ȸ����ȣ, ȸ������]
public class Member {
	private int number;
	private String name;
	private String phone;
	private char gender;
	
	//������
	public Member(int number, String name, String phone, char gender) {
		this.setNumber(number);
		this.setName(name);
		this.setPhone(phone);
		this.setGender(gender);
	}
	
	public Member(int number, String name) {
		this(number, name, "", ' ');
	}

	//get & set
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {		// �ܺη� ����!!!!!!!!!!!!!!!!!
		this.number = number;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	//method
	public void Println() {
		System.out.println("[ȸ����ȣ]" + number);
		System.out.println("[�̸�]" + name);
		System.out.println("[��ȭ��ȣ]" + phone);
		System.out.println("[����]" + gender);
	}
	
	public void Print() {
		System.out.printf("[%d] %s %s %c\n", number, name, phone, gender);
	}
	
}
