package example1;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParseTree ptree = new ParseTree();
		
		String	str = "3 2 + 4 * 2 -";
		ptree.MakeParseTree(str);
		
		System.out.println(ptree.getCount());
		System.out.println((char)ptree.getNodeKey());

		System.out.print("전위 : ");
		ptree.PreOrder();
		System.out.println();
		ptree.PreOrder_Non();
		System.out.print("중위 : ");
		ptree.InOrder();
		System.out.println();
		ptree.InOrder_Non();
		System.out.print("후위 : ");
		ptree.PostOrder();
	}

}
