package example2;

import java.util.Scanner;

public class Start {
	public static void exam1() {
		try {
			
		
		/*
		 * [���� ��� ��ɾ�]
		 * push 10
		 * pop
		 * gettop
		 * clear
		 * exit
		 */
		
		Scanner scan = new Scanner(System.in);	//import java.util
		MyQueue queue = new MyQueue();		
		
		System.out.println("-------------------------------------------");
		System.out.println(" ��ɾ� ��� ���� ���Ḯ��Ʈ �׽�Ʈ");
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
		System.out.println(" ���α׷��� �����մϴ�.");
		System.out.println("-------------------------------------------");
		
		scan.close();
		}
		catch(Exception ex) {
			System.out.println("������ �߻��߽��ϴ�."+ex.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exam1();
	}

}
