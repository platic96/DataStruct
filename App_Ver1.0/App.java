
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
			try {
				Global_Menu.main_Menu();
				// 명령어를 받아서 나눈다.
				String input = Global_Menu.InputString("명령어 입력");
				String[] sp = input.split(" ");

				switch (sp[0]) {

				case "exit":
					return;
				case "Insert":
					if (man.InsertUser(sp[1], Integer.parseInt(sp[2])))
						System.out.println("회원 등록이 완료되었습니다..");
					else
						System.out.println("이미 존재하는 계정 또는 잔고의 입력이 잘못되었습니다.");
					break;

				case "Select":
					User user = man.SelectUser(sp[1]);
					if (user == null)
						System.out.println("등록되지 않은 계정입니다");
					else
						System.out.println(user.toString());
					break;
				case "SelectAll":
					man.PrintAllUser();
					break;

				case "Delete":
					if (man.DeleteUser(sp[1]))
						System.out.println("삭제가 완료 되었습니다");
					else
						System.out.println("등록되지 않은 계정입니다.");
					break;

				case "Login":
					input = Global_Menu.InputString("아이디를 입력하세요");

					// id를 이용해서 객체를 가져온다.
					user = man.SelectUser(input);

					if (user == null)
						System.out.println("등록되지 않은 계정입니다.");

					// 예약 또는 취소 명령어 입력 ex) Book <좌석번호>
					else {
						String yn;
						if (man.getSrt().IsSoldout()) {
							yn = Global_Menu.InputString("좌석이 모두 매진 되었습니다. 대기열에 등록하시겠습니까? (Y/N)");
							if (yn.equals("Y")) {
								System.out.println("대기열에 등록되었습니다.");
								man.waitUserAdd(user);
							}
						}

						man.getSrt().PrintAll();
						Global_Menu.Book_Print();
						String[] book_sp = Global_Menu.InputString("명령어 입력").split(" ");
						switch (book_sp[0]) {
						case "Book":
							man.Book_Seat(Integer.parseInt(book_sp[1]), user);

							break;

						case "Cancle":
							boolean isSoldout = man.getSrt().IsSoldout();

							if (man.Cancle_Seat(Integer.parseInt(book_sp[1]), user) && isSoldout)
								man.Book_Seat(Integer.parseInt(book_sp[1]), man.waitUserDel());

						}
					}
					break;
				}

			} catch (Exception e) {
				System.out.println("잘못 입력하셧습니다.");

			}
		}
	}
}
