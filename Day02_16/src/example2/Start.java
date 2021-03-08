package example2;

import java.util.Scanner;

public class Start {
	public static void exam1() {
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
		MyQueue queue = new MyQueue();		
		
		System.out.println("-------------------------------------------");
		System.out.println(" 명령어 기반 단일 연결리스트 테스트");
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
				value = (int)queue.get();
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
		// TODO Auto-generated method stub
		exam1();
	}

}
