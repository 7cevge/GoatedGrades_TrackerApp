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
				return false;
			} else {
				Start.setCurrentUser(username);
				return true;
			}

		} catch (Exception err) {
			System.err.println(err);
			Start.setCurrentUser(null);
			return false;
		}
	}

	public static boolean register(String username) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
			PreparedStatement query;

			if (username.length() < 2 || username.length() > 16) {
				return false;
			}

			query = connection.prepareStatement("insert into users values (?)");
			query.setString(1, username);
			query.executeUpdate();

			return true;

		} catch (Exception err) {
			System.err.println(err);
			Start.setCurrentUser(null);
			return false;
		}
	}

	public static boolean delete(String username) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
			PreparedStatement query;

			query = connection.prepareStatement("delete from users where username = ?");
			query.setString(1, username);
			query.executeUpdate();

			Start.setCurrentUser(null);

			return true;

		} catch (Exception err) {
			System.err.println(err);
			return false;
		}
	}
}
