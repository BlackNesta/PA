package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
    Connection connection;

    public AlbumController(Connection con) {
        connection = con;
    }

    public void Create(String name, int artistId, int releaseYear) throws SQLException {
        Statement stmt;
        stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO albums (name,artist_id,release_year) " + "VALUES ('" + name + "','" + artistId + "','" + releaseYear + "')");
    }

    public void FindByArtist(int artistId) throws SQLException {
        Statement stmt;
        ResultSet rs;
        stmt = connection.createStatement();
        rs = stmt.executeQuery("SELECT * FROM albums WHERE artist_id = '" + artistId + "'");
        System.out.println("Find by artist " + artistId + ":{ ");
        while (rs.next())
            System.out.println("Id:" + rs.getInt("Id") + ", name: " + rs.getString(2) + ", artistId: " + rs.getString(3) + ", releaseYear: " + rs.getString(4));
        System.out.println("}");
    }
}
