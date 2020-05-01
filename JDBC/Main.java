package JDBC;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here
        // instanta a bazei de date
        DataBase db = DataBase.getInstance();

        //artistController si albumControlul sunt instante publice a obiecutului DataBase db
        db.artistController.Create("50Cent","NYC");
        db.artistController.FindByName("50Cent");

        db.albumController.Create("albumNou",1,2019);
        db.albumController.FindByArtist(1);
    }
}
