import java.util.Scanner;

public class Start {
	
	public static void exam1() {
		MyList list = new MyList();
		for(int i=10; i<= 50; i = i+10) {
			list.back_Insert(i);  //�ڽ�  Object(���۷���Ÿ��) = int(�⺻��Ÿ��)
		}
		
		list.selectall();
		
		//�˻� Ȯ��
		Node cur = list.Select(80); //���۰�, �߰���, ��������, ���°�
		if(cur != null)
			System.out.println("�˻���� : " + (int)cur.data);
		else
			System.out.println("����");
	}
	
	public static void exam2() {
		MyList list = new MyList();
		for(int i=10; i<= 50; i = i+10) {
			list.back_Insert(i);  //�ڽ�  Object(���۷���Ÿ��) = int(�⺻��Ÿ��)
		}
		
		list.selectall();
		
		for(int i=0; i<7; i++) {			
			list.back_delete();
			list.selectall();
		}
	}
	
	//��ɾ� ���
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
		System.out.println(" ��ɾ� ��� ���� ���Ḯ��Ʈ �׽�Ʈ");
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
					System.out.println("�˻���� : " + (int)cur.data);
				}
				else {
					System.out.println("����");
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
				
				Node cur = list.Select(find);		//�˻�����!
				if(cur != null) {
					list.random_Insert(cur,  value);
				}
				else {
					System.out.println("����");
				}				
			}

			else if(sp[0].equals("exit")) {
				break;
			}
			else if(sp[0].equals("r_delete")) {
				//r_delete 20
				int find = Integer.parseInt(sp[1]);
				
				Node cur = list.Select(find);		//�˻�����!
				if(cur != null) {
					list.random_delete(cur);
				}
				else {
					System.out.println("����");
				}		
			}
			list.selectall();
			System.out.println();
		}
		
		System.out.println("-------------------------------------------");
		System.out.println(" ���α׷��� �����մϴ�.");
		System.out.println("-------------------------------------------");
		
		scan.close();
	}
	
	public static void exam4() {
		MyList list = new MyList();
		for(int i=10; i<= 50; i = i+10) {
			list.back_Insert(i);  //�ڽ�  Object(���۷���Ÿ��) = int(�⺻��Ÿ��)
		}
		
		list.selectall();
		
	}
	public static void main(String[] args) {
		exam3();
	}
}













