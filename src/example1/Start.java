package example1;

public class Start {
	public static void exam1() {
		MyHash hs = new MyHash(10);
		int value = 0;
		for(int i=0; i<10; i++) {
			value = (int)(Math.random()*100) + 1;
			hs.Insert(value);
			//hs.PrintAll();
		}
		
		hs.PrintAll();
		
		//�˻�
		int idx = hs.Select(value);
		if(idx == -1) {
			System.out.println("����.");
		}
		else
			System.out.println("�˻���� : " + hs.getData(idx));
	}
	
	public static void main(String[] args) {
		exam1();
	}
}
