package sample1;

public class Start {
	public static void exam1() {
		MyDList list = new MyDList();
		for(int i=10;i<=50;i=i+10) {
			 list.push_front(i);
		}
		list.Select_NextAll();
		list.Select_PrevAll();
		
		MyDList.DNode cur= list.Select(30);
		if(cur != null)
			System.out.println(cur.data+ "�Դϴ�.");
		else
			System.out.println("����");
	}
	//random insert
		public static void exam2() {
			MyDList list = new MyDList();
			for(int i=10; i<= 50; i = i+10) {
				list.push_back(i);  //�ڽ�  Object(���۷���Ÿ��) = int(�⺻��Ÿ��)
			}
			
			list.Select_NextAll();  //10 20 30 40 50
			list.Select_PrevAll();  //50 40 30 20 10 
			
			 MyDList.DNode node = list.getHead();
			 node = node.next.next;  // 30�� �����ϰ� �ִ� ���.
			 list.push_random(node, 35);
			 
			 list.Select_NextAll();  //10 20 30 35 40 50
			 list.Select_PrevAll();  //50 40 35 30 20 10
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exam1();
	}

}
