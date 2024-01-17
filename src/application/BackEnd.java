package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BackEnd {

	public static void loginQ(String userName, String userPassword) {
		int userId = -1;

		try (Connection connection = DriverManager.getConnection(DataBaseKey.dataBaseId, DataBaseKey.userId,
				DataBaseKey.password);) {
			ResultSet result;
			PreparedStatement query;

			query = connection.prepareStatement(
					"select userId from useresult where useresult.userName = ? and useresult.userPassword = ?");
			query.setString(1, userName);
			query.setString(2, userPassword);
			result = query.executeQuery();

			while (result.next()) {
				userId = result.getInt(userId);
			}

			System.out.println(userId);
			SubController.setCurrentUserId(userId);
		} catch (Exception err) {
			System.err.println(err);
			SubController.setCurrentUserId(-1);
		}
	}
}
