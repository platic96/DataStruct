
public class Manager {
	private MyDList userList = new MyDList();
	private SRT srt;
	private MyQueue queue;

	public Manager() {
		srt = new SRT(5, 5);
		queue = new MyQueue(10);
	}

	// 새로운 회원을 추가하는 메서드
	public boolean InsertUser(String userId, int balance) {

		if (userId.equals("") || SelectUser(userId) != null) {
			return false;
		}

		User newUser = new User(userId, balance);
		if (!userList.push_back(newUser))
			return false;

		return true;
	}

	// 회원 정보를 조회하는 메서드
	public User SelectUser(String userId) {
		MyDList.DNode node = userList.select(userId);

		if (node != null)
			return (User) node.getData();
		else
			return null;
	}

	// 모든 회원 정보를 조회하는 메서드
	public void PrintAllUser() {
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("현재 회원 수는 " + userList.getSize() + "명입니다.");
		if (userList.getHead() != null)
			userList.selectNextAll();
		System.out.println("-----------------------------------------------------------------------------------------");
	}

	// 회원을 삭제하는 메서드
	public boolean DeleteUser(String userId) {

		MyDList.DNode del = userList.select(userId);
		if (del != null) {
			userList.erase_random(del);
			return true;
		} else {
			return false;
		}
	}

	// �¼� ����
	public boolean Book_Seat(int Seat_number, User userId) {
		return srt.Choice_Seat(Seat_number, userId);
	}

	public boolean Cancle_Seat(int Seat_number, User userId) {
		return srt.Cancle_Seat(userId);
	}

	public boolean waitUserAdd(User user) {
		return queue.Put(user);
	}

	public boolean waitUserDel() {
		if (queue.get() == null)
			return false;
		else
			return true;
	}
	public SRT getSrt() {
		return srt;
	}

}
