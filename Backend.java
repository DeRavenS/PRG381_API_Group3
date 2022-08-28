import LayeredArch.BusinessLogicLayer.DataHandler;

import java.sql.Connection;

public class Backend {
    public static void main(String[] args){
        DataHandler dh = new DataHandler();
        Connection conn = dh.getDBConnection();
        
        //some code

        dh.closeConnection(conn);
    }
}
