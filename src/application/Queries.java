package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Queries {
	public static boolean login(String username) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
			ResultSet result;
			PreparedStatement query;

			query = connection.prepareStatement(
					"select username from users where users.username = ?");
			query.setString(1, username);
			result = query.executeQuery();

			while (result.next()) {
				username = result.getString("username");
			}

			System.out.println(username);
			SceneController.setCurrentUser(username);
			return true;
		} catch (Exception err) {
			System.err.println(err);
			SceneController.setCurrentUser(null);
		}
		return false;
	}
}
