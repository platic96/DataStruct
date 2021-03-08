
public class App {
	private Manager man = new Manager();


	public App() {
		Init();
	}

	private void Init() {
		Global_Menu.logo();
	}

	public void run() {
		while (true) {
			Global_Menu.main_Menu();
			// 명령어를 받아서 나눈다.
			String input = Global_Menu.InputString("명령어 입력");
			String[] sp = input.split(" ");

			switch (sp[0]) {

			case "Insert":
				if (man.InsertUser(sp[1], Integer.parseInt(sp[2])))
					System.out.println("회원 등록이 완료되어 있습니다.");
				else
					System.out.println("이미 존재하는 계정입니다.");
				break;

			case "Select":
				User user = man.SelectUser(sp[1]);
				if (user == null)
					System.out.println("등록되지 않은 계정입니다");
				else
					System.out.println(user.toString());
				break;

			case "Delete":
				if (man.DeleteUser(sp[1]))
					System.out.println("삭제가 완료 되었습니다");
				else
					System.out.println("등록되지 않은 계정입니다.");
				break;

			default:
				// id를 이용해서 객체를 가져온다.
				user = man.SelectUser(sp[0]);

				if (user == null)
					System.out.println("등록되지 않은 계정입니다.");

				// 예약 또는 취소 명령어 입력 ex) Book <좌석번호>
				else {
					man.getSrt().PrintAll();
					Global_Menu.Book_Print();
					String[] book_sp = Global_Menu.InputString("명령어 입력").split(" ");
					switch(book_sp[0]) {
					case "Book":
						man.Book_Seat(Integer.parseInt(book_sp[1]), user);
						
						break;
						
					case "Cancle":
						man.Cancle_Seat(Integer.parseInt(book_sp[1]), user);
	
					}
				}
				break;
			}
		}
	}
}
