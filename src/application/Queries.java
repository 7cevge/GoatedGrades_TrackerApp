package application;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Queries {
	public static Estat login(String username, String password) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
			ResultSet result;
			PreparedStatement query;

			int userId = -1;

			query = connection.prepareStatement(
				"select userId from users where users.username = ? and users.userpw = ?");
			query.setString(1, username);
			query.setString(2, password);
			result = query.executeQuery();

			while (result.next()) {
				userId = result.getInt("userId");
			}

			if (userId == -1) {
				// Exact match not found
				userId = -1;

				query = connection.prepareStatement(
					"select userId from users where users.username = ?");
				query.setString(1, username);
				result = query.executeQuery();

				while (result.next()) {
					userId = result.getInt("userId");
				}

				if (userId == -1) {
					return Estat.UserNotFound;
				} else {
					return Estat.UserpwMismatch;
				}

			} else {
				Start.setCurrentUser(userId);
				return Estat.Successful;
			}

		} catch (Exception err) {
			System.err.println(err);
			Start.setCurrentUser(-1);
			return Estat.Error;
		}
	}

	public static Estat register(String username, String password) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
			PreparedStatement query;

			if (username.length() < 2 || username.length() > 16) {
				return Estat.Invalid;
			}

			query = connection.prepareStatement("insert into users(username, userpw) values (?, ?)");
			query.setString(1, username);
			query.setString(2, password);
			query.executeUpdate();

			return Estat.Successful;

		} catch (Exception err) {
			System.err.println(err);
			Start.setCurrentUser(-1);
			return Estat.Error;
		}
	}

	public static boolean delete(int userId) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
			PreparedStatement query;

			query = connection.prepareStatement("delete from users where userId = ?");
			query.setInt(1, userId);
			query.executeUpdate();

			Start.setCurrentUser(-1);

			return true;

		} catch (Exception err) {
			System.err.println(err);
			return false;
		}
	}

	public static String[] getUserInfo(int userId) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
			ResultSet result;
			PreparedStatement query;

			String[] userInfo = new String[5];
			int i = 0;

			query = connection.prepareStatement(
				"select * from users where users.userId = ?");
			query.setInt(1, userId);
			result = query.executeQuery();

			while (result.next()) {
				userInfo[i] = result.getString(i +1);
				i++;
			}

			return userInfo;

		} catch (Exception err) {
			System.err.println(err);
			Start.setCurrentUser(-1);
			return null;
		}
	}

	// ---------------------------------------------------------------------------------- Get Info
	public static void getAllInfo() { // for now just get all info to a txt
		try {
			System.out.println("try start write");
			FileWriter writer = new FileWriter("allInfo.txt");
			writer.write("???");
			writer.close();
			System.out.println("done write");
			/* 
			Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
			ResultSet result;
			PreparedStatement query;

			query = connection.prepareStatement(
				"select username from users where users.username = ?");
			query.setString(1, username);
			result = query.executeQuery();

			while (result.next()) {
				fromDB = result.getString("username");
			}*/

		} catch (Exception err) {
			System.err.println(err.getMessage());
		}
	}

	// ------------------------------------------------------------------------- Set / Modify Info
	public static void modifyInfo() {/* 
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
			PreparedStatement query;

			query = connection.prepareStatement("insert into users values (?)");
			query.setString(1, username);
			query.executeUpdate();

		} catch (Exception err) {
			System.err.println(err);
		}
	*/}

}
