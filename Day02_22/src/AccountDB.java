import java.sql.*;

public class AccountDB {
	Connection con;
	Statement stmt;
	
	public AccountDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 연결 성공");;
//			con = DriverManager.getConnection("jdbc:mysql://localhost/sampledb","root","20132991");
			con = DriverManager.getConnection("dbc:mysql://localhost:3306/sampleDB?serverTimezone=UTC&useSSL=false","root","20132991");
			System.out.println("데이터 베이스 연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public boolean Insert(int id, String name) {
		String query = "insert into account(accid,name)" + "values(" + id + "," + name + "" + "0" + ");";
		try{
			int i=stmt.executeUpdate(query);
			if(i>0)
				return true;
		}
		catch(Exception ex) {
			return false;
		}
		return false;
	}
	
	
	public boolean Insert(int id, String name, int balance) {
		String query = "insert into account(accid,name)" + "values(" + id + "," + name + "" + balance + ");";
		try{
			int i=stmt.executeUpdate(query);
			ExcuteUpdate(query);
		}
		catch(Exception ex) {
			return false;
		}
		return false;
	}
	
	private void ExcuteUpdate(String query) throws Exception{
		try {
			int i=stmt.executeUpdate(query);
			if(i<= 0)
				throw new Exception("변경된 데이터가 없음");
		}catch(Exception e){
			throw new Exception("에러 -" + e.getMessage());
		}
	}
	
	public boolean Update(int id, boolean isInput, int money) {
		try {	
			String query; 
			if( isInput == true)
			query = String.format("update account set balance= balance+ %d where accid=%d;",
							id, money);
			else
				query = String.format("update account set balance= balance- %d where accid=%d;",
						id, money);
			
			ExcuteUpdate(query);
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}	
	}

	
}
