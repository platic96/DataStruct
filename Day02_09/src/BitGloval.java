
import java.util.Scanner;

public class BitGloval {
	static Scanner sc = new Scanner(System.in);

	//메서드
	public static void Logo() {
		System.out.println("***********************");
		System.out.println("프로그램을 시작합니다.");
		System.out.println("2021.02.09");
		System.out.println("배열 자료구조를 활용한 회원 관리 프로그램");
		System.out.println("정민용");
		System.out.println("***********************");
	}
	
	public static void Ending() {
		System.out.println("***********************");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("***********************");
	}
	
	public static char MenuPrint() {

		System.out.println("***********************");
		System.out.println("[0]. 프로그램종료\n");
		System.out.println("[1]. 저장\n");
		System.out.println("[2]. 검색\n");
		System.out.println("[3]. 수정\n");
		System.out.println("[4]. 삭제\n");
		System.out.println("***********************");
		System.out.println(" >> ");
		return sc.nextLine().charAt(0);
	}
	
	//pause 멈추는 기능
	public static void Pause() {
		System.out.println("엔터키를 누르세요.");
		sc.nextLine();
	}

	public static int InputNumber(String msg) {
		System.out.println(msg);
		return Integer.parseInt(sc.nextLine());
	}
	
	public static String InputString(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}
	
	public static char InputChar(String msg) {
		System.out.println(msg);
		return sc.nextLine().charAt(0) ;
	}
}
