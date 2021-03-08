

import java.util.Scanner;

public class Global_Menu {
	
	static Scanner sc = new Scanner(System.in);

	
	public static void logo() {
		System.out.println("*************************************************");
		System.out.println(" SRT 관리 프로그램 ");
		System.out.println(" 2021.02.09");
		System.out.println(" C조 ");
		System.out.println("*************************************************\n");
		pause();
	}
	public static void pause() {
		System.out.print("Enter를 입력하세요.");
		sc.nextLine();		
	}
	public static void  ending() {
		System.out.println("*************************************************");
		System.out.println(" 프로그램을 종료합니다.");
		System.out.println("*************************************************");
	}
	
	public static void main_Menu() {
		System.out.println("*************************************************");
		System.out.println(" 프로그램 명령어");
		System.out.println(" 회원 등록 : Insert <ID> <잔고>");
		System.out.println(" 회원 검색 : Select <ID>");
		System.out.println(" 전체 회원 : SelectAll");
		System.out.println(" 회원 삭제 : Delete <ID>");
		System.out.println(" 예약 or 취소: Login");
		System.out.println(" 종료 : exit");
		System.out.println("*************************************************");
	}
	
	public static void Book_Print() {
		System.out.println("*************************************************");
		System.out.println(" 좌석 예약하기 : Book <좌석번호>");
		System.out.println(" 예약 취소하기 : Cancle <좌석번호>");
		System.out.println("*************************************************");
	}
	public static int InputNumber(String msg) {
		System.out.print(msg + " : ");
		return Integer.parseInt(sc.nextLine());
	}
	
	public static String InputString(String msg) {
		System.out.print(msg + " : ");
		return sc.nextLine();
	}
	
	public static char InputChar(String msg) {
		System.out.print(msg + " : ");
		return sc.nextLine().charAt(0);
	}

}
