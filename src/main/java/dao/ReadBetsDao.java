package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Bet;
import model.Search;

public class ReadBetsDao {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/gambling?autoReconnect=true&useSSL=false";

	public List<Bet> readBets() {
		List<Bet> betsList = new ArrayList<Bet>();

		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, "root", "password");
			String query = "select * from bets";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				
				Bet bet = new Bet();
				bet.setId(resultSet.getInt("id"));
				bet.setNumbets(resultSet.getInt("numbets"));
				bet.setGame(resultSet.getString("game"));
				bet.setStake(resultSet.getDouble("stake"));
				bet.setReturns(resultSet.getDouble("returns"));
				bet.setClientId(resultSet.getInt("clientid"));
				bet.setDate(resultSet.getString("date"));
				
				betsList.add(bet);
			}

			connection.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return betsList;
	}

	public List<Bet> filterBets(Search search) {
		List<Bet> betsList = new ArrayList<Bet>();

		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, "root", "password");
			String query = null;
			switch (search.getFilterBy()) {
			case "game":
				query = "select * from bets where game = ?";
				break;
			case "clientid":
				query = "select * from bets where clientid = ?";
				break;
			case "date":
				query = "select * from bets where date = ?";
				break;
			}
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, search.getSearchKeyword());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Bet bet = new Bet();
				bet.setId(resultSet.getInt("id"));
				bet.setNumbets(resultSet.getInt("numbets"));
				bet.setGame(resultSet.getString("game"));
				bet.setStake(resultSet.getDouble("stake"));
				bet.setReturns(resultSet.getDouble("returns"));
				bet.setClientId(resultSet.getInt("clientid"));
				bet.setDate(resultSet.getString("date"));
				
				betsList.add(bet);
			}

			connection.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return betsList;
	}
}
