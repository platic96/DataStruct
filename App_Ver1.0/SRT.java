
public class SRT {
	public class Seat {
		private String userId;

		public Seat() {
			this.userId = null;
		}

		public boolean IsEmpty() {
			return userId == null;
		}

		public boolean Reservation(String userId) {
			if (IsEmpty() == true) {
				this.userId = userId;
				return true;
			} else
				return false;
		}

		public void Cancle() {
			this.userId = null;
		}
	}

	private Seat[] seatArr;
	private int SRT_Number;
	private int seatCount;
	private int Charge;
	private int maxSeat;

	// 생성자
//   public SRT(int seatCount,int SRT_Number) {
//      this(seatCount,SRT_Number,40);
//   }
//   
	public SRT(int maxSeat, int SRT_Number) {
		this.seatArr = new Seat[maxSeat];
		this.SRT_Number = SRT_Number;
		this.Charge = 400;
		for (int i = 0; i < maxSeat; i++)
			seatArr[i] = new Seat();
		this.seatCount = 0;
		this.maxSeat = maxSeat;
	}

	// 메소드
	// 전체 출력
	public void PrintAll() {
		for (int i = 1; i <= seatArr.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for (int i = 0; i < seatArr.length; i++) {
			if (seatArr[i].IsEmpty() == false) {
				System.out.print("1\t");
			} else
				System.out.print("0\t");
		}
		System.out.println(" ");
	}

	// 만석확인
	public boolean IsSoldout() {
		return (seatArr.length <= seatCount);
	}

	// 좌석 선택
	public boolean Choice_Seat(int Seat_number, User userId) {
		Seat_number -= 1;
		if (Seat_number >= maxSeat) {
			System.out.println("없는 좌석입니다.");
			return false;
		}
		if (IsSoldout() == true) {
			System.out.println("좌석이 가득 찼습니다.");
			return false;
		} else {
			if (seatArr[Seat_number].IsEmpty() == false) {
				System.out.println("좌석은 이미 예약되었습니다.");
				return false;
			} else {
				if (userId.getBalance() < this.Charge) {
					System.out.println("잔액이 부족합니다.");
					return false;
				} else {
					System.out.println("예약에 성공했습니다.");
					seatArr[Seat_number].Reservation(userId.getUserId());
					userId.Pay(Charge);
					seatCount++;
				}

			}
		}
		PrintAll();
		return true;
	}

	// 좌석 취소
	public boolean Cancle_Seat1(User userId) {
		for (int i = 0; i < seatArr.length; i++) {
			if (seatArr[i].userId == userId.getUserId()) {
				seatArr[i].Cancle();
				userId.Save(Charge);
				seatCount--;
				System.out.println("삭제에 성공했습니다.");
				return true;
			}
		}
		System.out.println("해당 아이디는 예약되지 않았습니다.");
		return false;
	}

	public boolean Cancle_Seat(int seatNumber, User userId) {
		if (maxSeat <= seatNumber)
			return false;
		for (int i = 1; i <= seatArr.length; i++) {
			if (seatArr[i - 1].userId == userId.getUserId()) {
				if (seatArr[seatNumber - 1].IsEmpty() != true) {
					seatArr[seatNumber - 1].Cancle();
					userId.Save(Charge);
					seatCount--;
					System.out.println("삭제에 성공했습니다.");
					return true;
				} else {
					System.out.println("해당 위치에 예매하지 않았습니다.");
					return false;
				}
			}
		}
		System.out.println("해당 아이디는 예약되지 않았습니다.");
		return false;

	}
}