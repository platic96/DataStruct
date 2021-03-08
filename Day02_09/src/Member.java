
public class Member {
	private int number;
	private String name;
	private String phone;
	private char gender;
	
	//생성자
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

	private void setNumber(int number) {
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
		System.out.println("[회원번호] : "+ number);
		System.out.println("[이름] : "+ name);
		System.out.println("[전화번호] : "+ phone);
		System.out.println("[성별] : "+ gender);
	}
	
	public void Print() {
		System.out.printf("[%d] %s %s %c \n",number,name,phone,gender);
	}
}
	
	