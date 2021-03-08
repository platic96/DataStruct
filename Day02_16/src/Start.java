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
		BitStack stack = new BitStack();		
		
		System.out.println("-------------------------------------------");
		System.out.println(" ��ɾ� ��� ���� ���Ḯ��Ʈ �׽�Ʈ");
		System.out.println("-------------------------------------------");
		int value;
		
		while(true) {
			System.out.print(">> ");
			String str = scan.nextLine();
			String[] sp = str.split(" ");
			if( sp[0].equals("push")){   //f_insert 10
				 value = Integer.parseInt(sp[1]);
				stack.Push(value);
			}
			else if(sp[0].equals("pop")) { 
				value = (int)stack.Pop();
			}
			else if(sp[0].equals("gettop")) {   //select 10
				value = (int)stack.GetTop();
				System.out.println("top�� �� :"+value);
			}
			else if(sp[0].equals("clear")) {
				stack.Clear();
			}
			else if(sp[0].equals("exit")) {
				break;
			}
			stack.PrintAll();
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
