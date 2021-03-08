package test;

public class App {
	BitArray[] bit=new BitArray[4];
	/*BitArray bit2;
	BitArray bit3;
	BitArray bit4;*/
	person[] ps;
	
	int test_size;
	
	public App(int _test_size) {
		this.ps = new person[4];
		for(int i=0;i<4;i++) {
			ps[i] = new person();
		}
		this.test_size = _test_size;
		for(int i=0;i<4;i++)
		{
			this.bit[i]= new BitArray(this.test_size);
		}
		try {
			for(int i=0;i<bit[0].getMax();i++) {
				bit[0].Insert((i%5)+1);
			}
		}catch(Exception ex){
			
		}
		try {
			for(int i=0;bit[1].getSize()<=bit[1].getMax();i++) {
				if((i%5)+1 == 2) {
					continue;
				}
				bit[1].Insert(2);
				bit[1].Insert(i%5+1);
			}
		}catch(Exception ex){
			
		}
		try {
			for(int i=0;bit[2].getSize()<=bit[2].getMax();i++) {
				bit[2].Insert(3);
				bit[2].Insert(3);
				bit[2].Insert(1);
				bit[2].Insert(1);
				bit[2].Insert(2);
				bit[2].Insert(2);
				bit[2].Insert(4);
				bit[2].Insert(4);
				bit[2].Insert(5);
				bit[2].Insert(5);
			}
		}catch(Exception ex){
			
		}
		try {
			for(int i=0;bit[3].getSize()<bit[3].getMax();i++) {
				int value = (int)(Math.random()*5+1);
				bit[3].Insert(value);
			}
		}catch(Exception ex){
			
		}
	}
	public person[] solution(BitArray answer) {
		for(int i=0;i<4;i++) {
			Check_Answer(answer, ps[i], bit[i]);
		}
		return ps;
	}
	
	public void Check_Answer(BitArray answer,person ps,BitArray bit) {
		for(int i=0;i<answer.getMax();i++) {
			if(bit.getData(i)==answer.getData(i))
				ps.ok++;
			else
				ps.no++;
		}
		
	}
	
	public void print_All() {
		for(int i=0;i<this.test_size;i++) {
			System.out.print(bit[0].getData(i)+" ");
		}
		System.out.println();
		for(int i=0;i<this.test_size;i++) {
			System.out.print(bit[1].getData(i)+" ");
		}
		System.out.println();
		for(int i=0;i<this.test_size;i++) {
			System.out.print(bit[2].getData(i)+" ");
		}
		System.out.println();
		for(int i=0;i<this.test_size;i++) {
			System.out.print(bit[3].getData(i)+" ");
		}
		System.out.println();
		
	}
}
