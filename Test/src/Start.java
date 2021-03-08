import java.sql.*;

public class Start {
	public static void exam1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception ex) {
			System.out.println("오류" + ex.getMessage());
		}
	}
	
	public static void exam2() {
		Connection conn;
	//드라이버클래스://호스트주소:포트/데이터베이스명""아이디""패스워드"
				try{//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampleDB","root","1234");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","root","20132991");
					System.out.println("데이터베이스 연결 성공");
					//---------------------------------------------------------------------
					//2. 명령객체(쿼리문을 가지고 dbms 명령을 내리는 객체)
					Statement st = conn.createStatement();
					
					//3. 만약 DB에서 정보를 획득
					ResultSet rs = null;
					
					//---------------------------------------------------------------------
					if(st.execute("Show databases")) {
						rs = st.getResultSet();
					}
					while(rs.next()) {
						String str =  rs.getString(1);
						System.out.println(str);
					}
					
					conn.close();
					System.out.println("데이터베이스 연결해제");
				}
				catch(Exception ex) {
					System.out.println("오류 : "+ex.getMessage());
				}

	}
	public static void main(String[] args) {
		exam1();
		exam2();
	}
}
