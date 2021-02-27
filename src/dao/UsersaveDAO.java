package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsersaveDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/docotsubu?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "****";
	private final String DB_PASS = "**********";

	public boolean save(String username,String pass) {

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			String sql = "INSERT INTO login_user(user_name,pass) VALUES(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, username);
			pStmt.setString(2, pass);

			int result = pStmt.executeUpdate();

			if(result != 1) {
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
