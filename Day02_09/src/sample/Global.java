package sample;

import java.util.Scanner;
public class Global {
	static Scanner sc = new Scanner(System.in);

	//�޼���
	public static void Logo() {
		System.out.println("***********************");
		System.out.println("���α׷��� �����մϴ�.");
		System.out.println("2021.02.09");
		System.out.println("�迭 �ڷᱸ���� Ȱ���� ���� ���� ���α׷�");
		System.out.println("���ο�");
		System.out.println("***********************");
	}
	
	public static void Ending() {
		System.out.println("***********************");
		System.out.println("���α׷��� �����մϴ�.");
		System.out.println("***********************");
	}
	
	public static char MenuPrint() {
		System.out.println("***********************");
		System.out.println("[0]. ���α׷�����\n");
		System.out.println("[1]. ���¹�ȣ ����\n");
		System.out.println("[2]. ���¹�ȣ �˻�\n");
		System.out.println("[3]. �Ա�\n");
		System.out.println("[4]. ���\n");
		System.out.println("[5]. ���¹�ȣ ����\n");
		System.out.println("***********************");
		System.out.println(" >> ");
		return sc.nextLine().charAt(0);
	}
	
	//pause ���ߴ� ���
	public static void Pause() {
		System.out.println("����Ű�� ��������.");
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
