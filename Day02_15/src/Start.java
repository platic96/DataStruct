import java.util.Scanner;

public class Start {
	
	public static void exam1() {
		MyList list = new MyList();
		for(int i=10; i<= 50; i = i+10) {
			list.back_Insert(i);  //박싱  Object(레퍼런스타입) = int(기본형타입)
		}
		
		list.selectall();
		
		//검색 확인
		Node cur = list.Select(80); //시작값, 중간값, 마지막값, 없는값
		if(cur != null)
			System.out.println("검색결과 : " + (int)cur.data);
		else
			System.out.println("없다");
	}
	
	public static void exam2() {
		MyList list = new MyList();
		for(int i=10; i<= 50; i = i+10) {
			list.back_Insert(i);  //박싱  Object(레퍼런스타입) = int(기본형타입)
		}
		
		list.selectall();
		
		for(int i=0; i<7; i++) {			
			list.back_delete();
			list.selectall();
		}
	}
	
	//명령어 기반
	/*
	 * f_insert 10
	 * b_insert 10
	 * select 20
	 * f_delete
	 * b_delete
	 * exit
	 */
	public static void exam3() {

		Scanner scan = new Scanner(System.in);	//import java.util
		MyList list = new MyList();		
		
		System.out.println("-------------------------------------------");
		System.out.println(" 명령어 기반 단일 연결리스트 테스트");
		System.out.println("-------------------------------------------");
		
		while(true) {
			System.out.print(">> ");
			String str = scan.nextLine();
			String[] sp = str.split(" ");
			if( sp[0].equals("f_insert")){   //f_insert 10
				int value = Integer.parseInt(sp[1]);
				list.front_Insert(value);
			}
			else if(sp[0].equals("b_insert")) { //b_insert 10
				int value = Integer.parseInt(sp[1]);
				list.back_Insert(value);
			}
			else if(sp[0].equals("select")) {   //select 10
				int value = Integer.parseInt(sp[1]);
				Node cur = list.Select(value);
				if(cur != null) {
					System.out.println("검색결과 : " + (int)cur.data);
				}
				else {
					System.out.println("없다");
				}
			}
			else if(sp[0].equals("f_delete")) {
				list.front_delete();
			}
			else if(sp[0].equals("b_delete")) {
				list.back_delete();
			}else if(sp[0].equals("r_Insert")) {  //r_insert 20 30 
				int find = Integer.parseInt(sp[1]);
				int value = Integer.parseInt(sp[2]);
				
				Node cur = list.Select(find);		//검색과정!
				if(cur != null) {
					list.random_Insert(cur,  value);
				}
				else {
					System.out.println("없다");
				}				
			}

			else if(sp[0].equals("exit")) {
				break;
			}
			else if(sp[0].equals("r_delete")) {
				//r_delete 20
				int find = Integer.parseInt(sp[1]);
				
				Node cur = list.Select(find);		//검색과정!
				if(cur != null) {
					list.random_delete(cur);
				}
				else {
					System.out.println("없다");
				}		
			}
			list.selectall();
			System.out.println();
		}
		
		System.out.println("-------------------------------------------");
		System.out.println(" 프로그램을 종료합니다.");
		System.out.println("-------------------------------------------");
		
		scan.close();
	}
	
	public static void exam4() {
		MyList list = new MyList();
		for(int i=10; i<= 50; i = i+10) {
			list.back_Insert(i);  //박싱  Object(레퍼런스타입) = int(기본형타입)
		}
		
		list.selectall();
		
	}
	public static void main(String[] args) {
		exam3();
	}
}













