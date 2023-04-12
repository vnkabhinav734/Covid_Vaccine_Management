package database;

import java.sql.Connection;

public interface IDatabaseConnection {
    Connection getDatabaseConnection() throws Exception;
    void stopDatabaseConnection();
}
