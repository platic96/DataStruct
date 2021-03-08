package example;

import java.util.Scanner;

public class Start {
	private Scanner sc =  new Scanner(System.in);
	
	private MyHashMap map = new MyHashMap(10);
	
	private void Insert(int number,String name, String phone, char geneder) {
		if(map.Insert(number,new Member(number,name,phone,geneder))) {
			System.out.println("성공");
		}
		else
			System.out.println("실패");
	}
	private void Select(int number) {
		Member mem = (Member)map.KeyToValue(number);
		if(mem == null)
			System.out.println("없다");
		else
			mem.Println();
	}
	
	public void Run() {

		while(true) {			

			map.PrintAll();
			System.out.print(">> ");

			String str = sc.nextLine();

			String[] sp = str.split(" ");

			if( sp[0].equals("insert")){   //insert 10

				Insert(Integer.parseInt(sp[1]),sp[2],sp[3],sp[4].charAt(0));

			}
			else if(sp[0].equals("select")) {
				Select(Integer.parseInt(sp[1]));
			}
			else if(sp[0].equals("exit")) {

					break;

			}

		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
