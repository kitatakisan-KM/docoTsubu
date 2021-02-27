package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/docotsubu?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "****";
	private final String DB_PASS = "********";

	public boolean login(String username,String pass) {

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			String sql = "SELECT id,user_name,pass FROM login_user WHERE user_name=? AND pass=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, username);
			pStmt.setString(2, pass);

			ResultSet rs = pStmt.executeQuery();

			if(!(rs.next())) {
				return false;
			}


		} catch (ClassNotFoundException e) {
            System.out.println("JDBCドライバのロードでエラーが発生しました");
            return false;
		}catch(SQLException e) {
			System.out.println("データベースへのアクセスでエラーが発生しました。");
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
