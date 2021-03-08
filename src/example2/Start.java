package example2;

import java.util.Scanner;

public class Start {
	private Scanner scan = new Scanner(System.in);
	
	private MyHashMap hmap = new MyHashMap(10);	
	
	private void Insert(int number, String name, String phone, char gender) {
		if(hmap.Insert(number, new Member(number, name, phone, gender))){
			System.out.println("성공");
		}
		else
			System.out.println("실패");
	}
	
	private void Select(int number) {
		Member mem = (Member)hmap.KeyToValue(number);
		if( mem == null)
			System.out.println("없다");
		else 
			mem.Println();
	}
	
	private void Delete(int number) {
		if(hmap.Delete(number) == true)
			System.out.println("삭제");
		else
			System.out.println("없는 번호");			
	}
	
	public void Run() {
		while(true) {			
			hmap.PrintAll();	//코드 수정

			System.out.print(">> ");
			String str = scan.nextLine();
			String[] sp = str.split(" ");
			
			if( sp[0].equals("insert")){   //insert 회원번호 이름 전화번호 성별
				Insert(Integer.parseInt(sp[1]), sp[2], sp[3], sp[4].charAt(0));
			}			
			else if(sp[0].equals("select")) { //select 회원번호
				Select(Integer.parseInt(sp[1]));
			}
			else if(sp[0].equals("delete")){  //select 회원번호
				Delete(Integer.parseInt(sp[1]));
			}
			else if(sp[0].equals("exit")) {
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		new Start().Run();
	}
}
