import java.sql.*;

public class backEnd {
	private static login signIn = new login();

	public static void main(String[] args) {
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
		} catch (SQLException sqle) {
			System.out.println("SQLException : " + sqle);
		}
	}
}
