package task17;

import org.h2.Driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

public class Main {

	static final String databaseURL = "jdbc:h2:tcp://localhost/~/test/test";
	static final String driver = "org.h2.Driver";

	static final String user = "sa";
	static final String rassword = "";

	public static Connection connection = null;
	public static Statement statement = null;

	public static void createTable() throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT * FROM ITEM;");
		int columns = rs.getMetaData().getColumnCount();
		while (rs.next())
			for (int i = 1; i <= columns; i++) {
				System.out.print(rs.getString(i) + " ");
			}
		System.out.println("\n");
		ResultSet rs2 = statement.executeQuery("SELECT * FROM ORDER;");
		int col = rs2.getMetaData().getColumnCount();
		while (rs2.next())
			for (int i = 1; i <= col; i++) {
				System.out.print(rs2.getString(i) + " ");
			}
		System.out.println("\n");
	}

	public static void main(String[] args) {

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(databaseURL, "sa", "");
			statement = connection.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS ITEM;\n" + "DROP TABLE IF EXISTS ORDER;");

			String sql = "CREATE TABLE ITEM(item_name VARCHAR(255) not NULL, price INTEGER not NULL, item_id VARCHAR(255) PRIMARY KEY);";
			sql += "\n CREATE TABLE ORDER (id INTEGER not NULL, login VARCHAR(255) not NULL, article VARCHAR(255) REFERENCES ITEM(item_id));";

			statement.executeUpdate(sql);

			BufferedReader r = new BufferedReader(new FileReader(args[0]));
			String line;
			while ((line = r.readLine()) != null) {
				String[] arrStr = line.split("[,\"]");

				String insertSql = "MERGE INTO ITEM USING (SELECT '" + arrStr[3]
						+ "' ITEM_ID) AS S ON ITEM.ITEM_ID = S.ITEM_ID" + " WHEN NOT MATCHED THEN INSERT VALUES ('"
						+ arrStr[4] + "', " + arrStr[5] + ", '" + arrStr[3] + "');";
				insertSql += "\n INSERT INTO ORDER VALUES (" + arrStr[1] + ", '" + arrStr[2] + "', '" + arrStr[3]
						+ "');\n";

				statement.executeUpdate(insertSql);
			}
			createTable();
			statement.close();
			connection.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}
}