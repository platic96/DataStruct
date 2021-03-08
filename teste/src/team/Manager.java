package team;

import java.util.ArrayList;

public class Manager {
	private MyQueue queue; // 대기열
	private DBQuery db;
	private Wait wt;

	public Manager() {
		queue = new MyQueue(10);
		db = new DBQuery();
		db.Run();
	}

	// public boolean Book_Seat(int Seat_number, User userId) {
	// return srt.Choice_Seat(Seat_number, userId);
	// }

	// public boolean Cancle_Seat(int Seat_number, User userId) {
	// return srt.Cancle_Seat(Seat_number, userId);
	// }

	public boolean waitUserAdd(User user) {
		return queue.Put(user);
	}

	public boolean waitUserDel() {
		if (queue.get() == null)
			return false;
		else
			return true;
	}

	// USER -------------------------------------------------------
	public boolean MakeUser(String id, int balance) {
		return db.MakeUser(id, balance);
	}

	public boolean PayCharge(String id, int money) {
		return db.PayCharge(id, money);
	}

	public boolean refundCharge(String id, int money) {
		return db.refundCharge(id, money);
	}

	public User SelectUser(String id) {
		return db.SelectUser(id);
	}

	public ArrayList<User> SelectAllUser() {
		return db.SelectAllUser();
	}

	public boolean DeleteUser(String id) {
		return db.DeleteUser(id);
	}

	// SRT -------------------------------------------------
	public boolean MakeSRT(int srt_number, int max_seat, int Charge) {
		return db.MakeSRT(srt_number, max_seat, Charge);
	}

	public SRT selectSrt(int srt_number) {
		return db.SelectSRT(srt_number);
	}

	public ArrayList<SRT> selectSrtAll() {
		return db.SelectAllSRT();
	}

	// Reservation -----------------------------------------

	// 구매와 돈 인출이 하나의 트랜잭션으로 관리되는 메서드
	public boolean Reservation(String id, int balance, int srt_number, int seat_number) {
		SRT srt = db.SelectSRT(srt_number);
		if (srt.IsSoldout() == true) {
			String yn = Global_Menu.InputString("대기열에 입장 하시겠습니까? (Y/N)");
			if (yn.equals("Y")) {
				// wt = db.SelectWait(srt_number);
				return db.AddWait(srt_number, id);
			} else
				return false;
		} else {
			srt.Choice_Seat(seat_number); // 좌석 현황 변경
			return db.Reservation(id, balance, srt_number, seat_number, srt.getSeat_state());
		}

	}

	// 예약 취소와 돈 환불이 하나의 트랜잭션으로 관리되는 메서드
	public boolean CancleReservation(String id, int money, int r_id, int srt_number) {
		SRT srt = db.SelectSRT(srt_number);
		Reservation rsv = db.SelectReservationRId(r_id);
		boolean w = srt.IsSoldout();
		srt.Cancle_Seat(rsv.seat_number); // 좌석 현황 변경
		db.CancleReservation(id, money, r_id, srt.getSeat_state(), srt_number);
		if (w) {
			srt.Choice_Seat(rsv.seat_number);
			wt = db.SelectWait(srt_number);
			String user_id = wt.getUser_id().pop();
			int w_id = wt.getW_id().pop();
			db.ReservationWait(user_id, money, srt_number, rsv.seat_number, srt.getSeat_state(), w_id);
			return true;
		} else {
			return false;
		}
	}

	public boolean ReservationSeat(String id, int srt_number, int seat_number) {
		return db.ReservationSeat(id, srt_number, seat_number);
	}

	public boolean ChangeSeatRId(int r_id, String user_id, int srt_number, int seat_number) {
		return db.ChangeSeatRId(r_id, user_id, srt_number, seat_number);
	}

	public boolean DeleteReservationRId(String user_id, int r_id) {
		return db.DeleteReservationRId(user_id, r_id);
	}

	public ArrayList<Reservation> SelectReservationUserId(String id) {
		return db.SelectReservationUserId(id);
	}

	public Reservation SelectReservationRId(int id) {
		return db.SelectReservationRId(id);
	}

	public ArrayList<Reservation> SelectReservationAll() {
		return db.SelectReservationAll();
	}
	
//	public ArrayList<Wait> SelectWaitAll(){
//		return db.SelectWaitAll();
//	}
}
