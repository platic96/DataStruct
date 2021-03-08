
public class User {
	private String userId; 
	private int balance;
	
	public User(String userId, int balance) {
		this.userId = userId;
		this.balance = balance;
	}
	
	// --------------------------------------------------- method ------------------------------------------
	// 회원이 예약을 취소할 경우 반환되는 금액을 입금받기 위한 메서드
	public boolean Save(int cost) {
		if ( cost <  0 ) 
			return false;
		
		balance += cost;
		return true;
	}
	
	// 회원이 예약 시 금액을 지불하기 위한 메서드
	public boolean Pay(int value) {
		if (balance >= value) {
			balance -= value;
		 	return true;
		}
		else {
		 	return false;
		} 
	}
	
	@Override
	public String toString() {
		return "[ 회원Id ] "+this.getUserId() + "\t [ 잔액 ] "+this.getBalance();
	}
	
	
	// --------------------------------------------------- Getter ------------------------------------------
	public boolean equals(String userId) {
		return this.userId.equals(userId);
	}
	
	public String getUserId()	{
		return this.userId;
	}
	
	public int  getBalance()	{
		return balance;
	}
}
