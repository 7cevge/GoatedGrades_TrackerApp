package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BackEnd {
	LoginKey signIn = new LoginKey();

	public String loginQ(String userName, String userPassword) {
		try (Connection c = DriverManager.getConnection(signIn.dbID, signIn.userID, signIn.pw);) {
			ResultSet rs;
			PreparedStatement ps;
			ps = c.prepareStatement("select * from users");
			rs = ps.executeQuery();
			String output = "";
			while (rs.next()) {
				output = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3);
			}
			System.out.println(output);
			return output;
		} catch (SQLException sqle) {
			System.out.println("SQLException : " + sqle);
			return "";
		}
	}
}
