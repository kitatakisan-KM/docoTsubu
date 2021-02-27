package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import login.Mutter;

public class MutterDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/docotsubu?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "*****";
	private final String DB_PASS = "********";

	public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<>();

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			String sql = "SELECT id,user_name,text FROM mutter ORDER BY id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("user_name");
				String text = rs.getString("text");
				Mutter mutter = new Mutter(id,username,text);
				mutterList.add(mutter);
			}


		} catch (ClassNotFoundException e) {
            System.out.println("JDBCドライバのロードでエラーが発生しました");
            return null;
		}catch(SQLException e) {
			System.out.println("データベースへのアクセスでエラーが発生しました。");
			e.printStackTrace();
			return null;
		}

		return mutterList;
	}

	public boolean create(Mutter mutter) {

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			String sql = "INSERT INTO mutter(user_name,text) VALUES(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getMutter());

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

