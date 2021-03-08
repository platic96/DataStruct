package example3;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBSearchTree bst = new MyBSearchTree();
		
		System.out.print("저장값 : ");
		for(int i=0; i<10; i++) {			
			int value = (int)(Math.random()*100)+1; //1~100
			System.out.print(value + " ");
			bst.Insert_NonRe(value);
		}
		//결과 확인...
		System.out.println("\n[순회 결과값]");
		bst.InOrder();		

		//검색 테스트
		MyBSearchTree.Node node = bst.Search(30);
		if(node == null)
			System.out.println("없다.");
		else
			System.out.println("찾은 값 : " + node.key);
	}

}
