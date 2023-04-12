package database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection implements IDatabaseConnection {

	private static final String DATABASE_CONFIGURATION_FILE = "./config.properties";
	private Connection connection = null;
	private static DatabaseConnection databaseConnection;

	public DatabaseConnection() {

	}

	public static DatabaseConnection instance() {
		if (databaseConnection == null) {
			databaseConnection = new DatabaseConnection();
		}
		return databaseConnection;
	}

	private Connection connectToDatabase() {
		try {
			final InputStream inputStream = new FileInputStream(DATABASE_CONFIGURATION_FILE);
			final Properties databaseConfigProperties = new Properties();
			databaseConfigProperties.load(inputStream);

			Class.forName(databaseConfigProperties.getProperty("mysqlJDBCDriver")).getDeclaredConstructor().newInstance();

			final String databaseType = databaseConfigProperties.getProperty("databaseType");
			final String databaseURL = databaseConfigProperties.getProperty("databaseURL") +
					databaseConfigProperties.getProperty(databaseType + "Database");
			final String databaseUserName = databaseConfigProperties.getProperty(databaseType + "Username");
			final String databasePassword = databaseConfigProperties.getProperty(databaseType + "Password");

			connection=DriverManager.getConnection(databaseURL, databaseUserName, databasePassword);
			return connection;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Error in connection");
		}
		return connection;
	}

	@Override
	public Connection getDatabaseConnection() throws Exception {
		stopDatabaseConnection();
		connection = connectToDatabase();
		return connection;
	}

	@Override
	public void stopDatabaseConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			connection = null;
		}
	}
}
