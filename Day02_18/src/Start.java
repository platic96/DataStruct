
public class Start {
	public static void exam1() {
		MyHash hs = new MyHash(10);
		int value=0;
		for(int i=0;i<20; i++) {
			value = (int)(Math.random()*100)+1;
			hs.Insert(value);
		}
		hs.PrintAll();
		int idx = hs.Select(value);
		System.out.println(value);
		if(idx ==-1)
			System.out.println("없다.");
		else
			System.out.println("검색 결과 : "+ hs.getData(idx));
		
	}
	
	public static void main(String[] args) {
		exam1();
	}
}
