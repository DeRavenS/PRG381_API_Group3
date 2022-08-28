package LayeredArch.BusinessLogicLayer;

import LayeredArch.DataAccessLayer.ConnectDB;

import java.sql.Connection;
import java.sql.SQLException;

public class DataHandler {
    public Connection getDBConnection(){
        ConnectDB getDB = new ConnectDB();
        return getDB.connectDatabase("root","");
    }

    public void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
