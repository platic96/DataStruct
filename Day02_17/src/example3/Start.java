package example3;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBSearchTree bst = new MyBSearchTree();
		
		System.out.print("���尪 : ");
		for(int i=0; i<10; i++) {			
			int value = (int)(Math.random()*100)+1; //1~100
			System.out.print(value + " ");
			bst.Insert_NonRe(value);
		}
		//��� Ȯ��...
		System.out.println("\n[��ȸ �����]");
		bst.InOrder();		

		//�˻� �׽�Ʈ
		MyBSearchTree.Node node = bst.Search(30);
		if(node == null)
			System.out.println("����.");
		else
			System.out.println("ã�� �� : " + node.key);
	}

}
