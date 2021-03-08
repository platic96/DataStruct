package team;

import java.util.LinkedList;

public class Wait {
	public LinkedList<Integer> w_id;
	private int srt_number;
	public LinkedList<String> user_id;
	
	public Wait(int srt_number) {
		this.srt_number = srt_number;
		w_id = new LinkedList<Integer>();
		user_id = new LinkedList<String>();
	}
	
	public Wait(int srt_number, LinkedList<Integer> w_id,LinkedList<String> user_id) {
		this.srt_number = srt_number;
		this.w_id = w_id;
		this.user_id = user_id;
	}
	
	public LinkedList<Integer> getW_id() {
		return w_id;
	}

	public void setW_id(LinkedList<Integer> w_id) {
		this.w_id = w_id;
	}

	public int getSrt_number() {
		return srt_number;
	}

	public void setSrt_number(int srt_number) {
		this.srt_number = srt_number;
	}

	public LinkedList<String> getUser_id() {
		return user_id;
	}

	public void setUser_id(LinkedList<String> user_id) {
		this.user_id = user_id;
	}

//	public String WaitPop() {
//		if(w_id.isEmpty())
//			return "";
//		return user_id.pop();
//	}
	
	@Override
	public String toString() {
		return "Wait [W_id=" + w_id + ", Srt_number=" + srt_number + "user_id="
				+ user_id;
	}
	public void Print() {
			System.out.println("Wait [W_id=" + w_id + ", Srt_number=" + srt_number + "user_id="
					+ user_id);
	}
	
	// 회원 검색 시 조회될 정보
	public void PrintWait() {
		System.out.println("[ 대기 번호 :  " + w_id + " , 예약차량 : "+ srt_number+ "  ]");
	}
}
