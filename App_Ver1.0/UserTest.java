import java.util.Scanner;

public class UserTest {
	public static void main(String args[]) {
		exam1();
	}
	
	public static void exam1() {
		Scanner scan = new Scanner(System.in);

		System.out.println("----------------------------------------");
		System.out.println("연결리스트를 활용한 회원 관리");
		System.out.println("----------------------------------------");		

		Manager manager = new Manager();
	
		while(true) {
			System.out.print(">> ");
			String str = scan.nextLine(); // 문장 하나를 받아들임
			String[] strArr = str.split(" ");

			if (strArr[0].equals("insertUser")) {
				String id = strArr[1];
				int value = Integer.parseInt(strArr[2]);
				if (!manager.InsertUser(id, value))
					System.out.println("회원 아이디가 중복되었거나 공백을 입력하였습니다.");
			}
			else if (strArr[0].equals("selectUser")) {
				String id = strArr[1];
				User  data = manager.SelectUser(id);
				if (data == null )
					System.out.println("저장된 데이터가 없습니다.");
				else 
					System.out.println(data.getUserId()+"/ "+data.getBalance());
			}			
			else if (strArr[0].equals("deleteUser")) {
				String id = strArr[1];
				manager.DeleteUser(id);
				System.out.println("회원 삭제");
			}
			else if (strArr[0].equals("selectAllUser")) {
				manager.PrintAllUser();
			}
			else if (strArr[0].equals("pay")) {
				String id = strArr[1];
				int value = Integer.parseInt(strArr[2]);
				User user = manager.SelectUser(id);
				System.out.println(user.getUserId()+"회원의 잔액 : "+user.getBalance());
				user.Pay(value);
				System.out.println(user.getUserId()+"회원의 잔액 : "+user.getBalance());
				
			}
			else if (strArr[0].equals("save")) {
				String id = strArr[1];
				int value = Integer.parseInt(strArr[2]);
				User user = manager.SelectUser(id);
				System.out.println(user.getUserId()+"회원의 잔액 : "+user.getBalance());
				if (user.Save(value))
					System.out.println(user.getUserId()+"회원의 잔액 : "+user.getBalance());
				else 
					System.out.println(user.getUserId()+"회원에게 "+value+"원을 입금하는 것에 실패하였습니다.");
				
			}
			else if (strArr[0].equals("exit")) {
				break;
			}
			
			System.out.println();
		}
		System.out.println("----------------------------------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("----------------------------------------");
		scan.close();
	}
}
