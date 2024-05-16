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

			String fromDB = null;

			query = connection.prepareStatement(
				"select username from users where users.username = ?");
			query.setString(1, username);
			result = query.executeQuery();

			while (result.next()) {
				fromDB = result.getString("username");
			}

			// check if it is in the database
			if (fromDB == null) {
				System.out.println("null");
				return false;
			} else {
				System.out.println("username: " + fromDB);
				SceneController.setCurrentUser(username);
				return true;
			}

		} catch (Exception err) {
			System.err.println(err);
			SceneController.setCurrentUser(null);
			return false;
		}
	}

	public static boolean register(String username) {
		System.out.println(username);
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
			PreparedStatement query;

			if (username.length() < 2 || username.length() > 16) {
				return false;
			}

			System.out.println("pre prep");
			query = connection.prepareStatement("insert into users values (?)");
			System.out.println("pre setStr");
			query.setString(1, username);
			System.out.println("pre exec");
			query.executeUpdate();

			return true;

		} catch (Exception err) {
			System.err.println(err);
			SceneController.setCurrentUser(null);
			return false;
		}
	}
}
