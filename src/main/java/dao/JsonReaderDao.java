package dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReaderDao {

	public void uploadJson() {
		try {

			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/gambling?autoReconnect=true&useSSL=false";
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, "root", "password");
			String query = "insert into bets (id, numbets, game, stake, returns, clientid, date)"
					+ "values (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			JSONParser jsonParser = new JSONParser();
			String dir = System.getProperty("user.dir");
			FileReader reader = new FileReader(dir + "\\Java-Web-Application\\src\\main\\resource\\bets.json");
			
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray betsJsonArray = (JSONArray) jsonObject.get("bets");

			for (int n = 0; n < betsJsonArray.size(); n++) {
				JSONObject betsJson = (JSONObject) betsJsonArray.get(n);
				preparedStatement.setInt(1, (int) (long) betsJson.get("id"));
				preparedStatement.setInt(2, (int) (long) betsJson.get("numbets"));
				preparedStatement.setString(3, (String) betsJson.get("game"));
				preparedStatement.setDouble(4, (Double) betsJson.get("stake"));
				preparedStatement.setDouble(5, (Double) betsJson.get("returns"));
				preparedStatement.setInt(6, (int) (long) betsJson.get("clientid"));
				preparedStatement.setString(7, (String) betsJson.get("date"));

				preparedStatement.execute();
			}

			connection.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
