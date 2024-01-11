package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BackEnd {
	LoginKey signIn = new LoginKey();

	public int loginQ(String userName, String userPassword) {
		int userId = -1;
		
		try (Connection c = DriverManager.getConnection(signIn.dbID, signIn.userID, signIn.pw);) {
			ResultSet rs;
			PreparedStatement ps;
			
			
			ps = c.prepareStatement("select userId from users where users.userName = ? and users.userPassword = ?");
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				userId = rs.getInt(userId);
			}
			
			System.out.println(userId);
			return userId;
		} catch (SQLException sqle) {
			System.out.println("SQLException : " + sqle);
			
			return userId;
		}
	}
}
