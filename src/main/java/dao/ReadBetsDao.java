package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReadBetsDao {

	public List readBets() {
		List betsList = new ArrayList();

		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/gambling?autoReconnect=true&useSSL=false";
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, "root", "password");
			String query = "select * from bets";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				betsList.add(resultSet.getInt("id"));
				betsList.add(resultSet.getInt("numbets"));
				betsList.add(resultSet.getString("game"));
				betsList.add(resultSet.getDouble("stake"));
				betsList.add(resultSet.getDouble("returns"));
				betsList.add(resultSet.getInt("clientid"));
				betsList.add(resultSet.getString("date"));
			}

			connection.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return betsList;
	}
}
