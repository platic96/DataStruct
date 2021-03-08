package sample2;

public class Room {
	private MyDList wait;
	private MyDList game1;
	private MyDList game2;
	private MyDList game3;
	
	public Room() {
		this.wait = new MyDList();
		this.game1 = new MyDList();
		this.game2 = new MyDList();
		this.game3 = new MyDList();
	}
	
	//메서드
	public void PrintAll() {
		System.out.println("---------------------------------");
		System.out.println("대기방\t"); wait.Select_NextAll();
		System.out.println("게임방1\t"); game1.Select_NextAll();
		System.out.println("게임방2\t"); game2.Select_NextAll();
		System.out.println("게임방3\t"); game3.Select_NextAll();
		
	}
	
	public boolean Insert(int number) {
		wait.push_back(number);
		return true;
	}
	public boolean Delete(int number) {
		MyDList.DNode del = wait.Select(number);
		if(del == null) {
			System.out.println(number + "는 없는 번호입니다.");
			return false;
		}
		else
			wait.erase_random(del);
		return true;
	}
	public boolean GameIn(int idx, int number) {
		switch(idx) {
		case 1 :if(this.Delete(number)) {
			 game1.push_back(number);
			}
		else {
			System.out.println("대기실에 없는 번호입니다.");
			return false;
			}break;
		case 2 : if(this.Delete(number)) {
			 game2.push_back(number);
			}
		else {
			System.out.println("대기실에 없는 번호입니다.");
			return false;
			}break;
		case 3 : if(this.Delete(number)) {
			 game1.push_back(number);
			}
		else {
			System.out.println("대기실에 없는 번호입니다.");
			}break;
		}
		return true;
	}
	public boolean GameOut(int idx,int number) {
		switch(idx) {
		case 1 :
			MyDList.DNode del = game1.Select(number);
			if(del == null) {
				System.out.println("게임방에 없는 번호 입니다.");
			}
			else {
				game1.erase_random(del);
			}
			break;
		case 2 : 
			MyDList.DNode del1 = game2.Select(number);
			if(del1 == null) {
				System.out.println("게임방에 없는 번호 입니다.");
			}
			else {
				game1.erase_random(del1);
			}break;
		case 3 : 
			MyDList.DNode del2 = game3.Select(number);
			if(del2 == null) {
				System.out.println("게임방에 없는 번호 입니다.");
			}
			else {
				game1.erase_random(del2);
			}break;
		}
		return true;
	}
	
}
