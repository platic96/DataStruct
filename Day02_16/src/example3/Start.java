package example3;

import java.util.Scanner;

public class Start {
	public static void exam2() {
		try {
			
		
		/*
		 * [스텍 사용 명령어]
		 * push 10
		 * pop
		 * gettop
		 * clear
		 * exit
		 */
		
		Scanner scan = new Scanner(System.in);	//import java.util
		MyLinkedQueue queue = new MyLinkedQueue();		
		
		System.out.println("-------------------------------------------");
		System.out.println(" 명령어 기반 MyLinkedQueue 테스트");
		System.out.println("-------------------------------------------");
		int value;
		
		while(true) {
			System.out.print(">> ");
			String str = scan.nextLine();
			String[] sp = str.split(" ");
			if( sp[0].equals("put")){   //f_insert 10
				 value = Integer.parseInt(sp[1]);
				queue.Put(value);
			}
			else if(sp[0].equals("get")) { 
				value = (int)queue.Get();
				System.out.println(value);
			}
			else if(sp[0].equals("clear")) {
				queue.Clear();
			}
			else if(sp[0].equals("exit")) {
				break;
			}
			queue.PrintAll();
			System.out.println();
		}
		
		System.out.println("-------------------------------------------");
		System.out.println(" 프로그램을 종료합니다.");
		System.out.println("-------------------------------------------");
		
		scan.close();
		}
		catch(Exception ex) {
			System.out.println("에러가 발생했습니다."+ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		exam2();
	}
}
