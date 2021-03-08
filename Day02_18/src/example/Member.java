package example;

//Member 객체 저장(number값을 key로 사용!) [회원번호, 회원정보]

public class Member {
	private int number;
	private String name;
	private String phone;
	private char gender;
	
	//������
	public Member(int _number, String _name, String _phone, char _gender ) {
		setNumber(_number);
		setName(_name);
		setPhone(_phone);
		setGender(_gender);
	}
	
	public Member(int number,String name) {
		this(number,name,"",' ');
	}


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
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
	
	public void Println() {
		System.out.println("[ȸ����ȣ] : "+ number);
		System.out.println("[�̸�] : "+ name);
		System.out.println("[��ȭ��ȣ] : "+ phone);
		System.out.println("[����] : "+ gender);
	}
	
	public void Print() {
		System.out.printf("[%d] %s %s %c \n",number,name,phone,gender);
	}
}
	
	