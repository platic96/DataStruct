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
			System.out.println(cur.data+ "입니다.");
		else
			System.out.println("없다");
	}
	//random insert
		public static void exam2() {
			MyDList list = new MyDList();
			for(int i=10; i<= 50; i = i+10) {
				list.push_back(i);  //박싱  Object(레퍼런스타입) = int(기본형타입)
			}
			
			list.Select_NextAll();  //10 20 30 40 50
			list.Select_PrevAll();  //50 40 30 20 10 
			
			 MyDList.DNode node = list.getHead();
			 node = node.next.next;  // 30을 저장하고 있는 노드.
			 list.push_random(node, 35);
			 
			 list.Select_NextAll();  //10 20 30 35 40 50
			 list.Select_PrevAll();  //50 40 35 30 20 10
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exam1();
	}

}
