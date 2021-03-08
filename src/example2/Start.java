package example2;

import java.util.Scanner;

public class Start {
	private Scanner scan = new Scanner(System.in);
	
	private MyHashMap hmap = new MyHashMap(10);	
	
	private void Insert(int number, String name, String phone, char gender) {
		if(hmap.Insert(number, new Member(number, name, phone, gender))){
			System.out.println("����");
		}
		else
			System.out.println("����");
	}
	
	private void Select(int number) {
		Member mem = (Member)hmap.KeyToValue(number);
		if( mem == null)
			System.out.println("����");
		else 
			mem.Println();
	}
	
	private void Delete(int number) {
		if(hmap.Delete(number) == true)
			System.out.println("����");
		else
			System.out.println("���� ��ȣ");			
	}
	
	public void Run() {
		while(true) {			
			hmap.PrintAll();	//�ڵ� ����

			System.out.print(">> ");
			String str = scan.nextLine();
			String[] sp = str.split(" ");
			
			if( sp[0].equals("insert")){   //insert ȸ����ȣ �̸� ��ȭ��ȣ ����
				Insert(Integer.parseInt(sp[1]), sp[2], sp[3], sp[4].charAt(0));
			}			
			else if(sp[0].equals("select")) { //select ȸ����ȣ
				Select(Integer.parseInt(sp[1]));
			}
			else if(sp[0].equals("delete")){  //select ȸ����ȣ
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
