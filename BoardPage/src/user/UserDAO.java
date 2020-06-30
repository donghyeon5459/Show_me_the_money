package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class UserDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/SMTM";
			String dbID = "root";
			String dbPassword = "Xorbs505!";
			Class.forName("com.mysql.jdbc.Drvier");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if(rs.getString(1).contentEquals(userPassword))
						return -1; // 濡쒓렇�씤 �꽦怨�  
				else 
					return 0; // 鍮꾨�踰덊샇 遺덉씪移�
			}
			return -1; // �븘�씠�뵒媛� �뾾�쓬
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; //�뜲�씠�꽣踰좎씠�뒪 �삤瑜� 
	}
	
	public int join(User user) {
		String SQL = "INSERT INTO USER (userID, userPassword, userName, userGender, userEmail) VALUES (?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
