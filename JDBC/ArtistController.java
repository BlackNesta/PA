package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {
    Connection connection;

    public ArtistController(Connection con) {
        connection = con;
    }

    public void Create(String name, String country) throws SQLException {
        Statement stmt;
        stmt = connection.createStatement();
        stmt.executeUpdate("INSERT INTO artists (name,country) " + "VALUES ('" + name + "','" + country + "')");
    }

    public void FindByName(String name) throws SQLException {
        Statement stmt;
        ResultSet rs;
        stmt = connection.createStatement();
        rs = stmt.executeQuery("SELECT * FROM artists WHERE name = '" + name + "'");

        System.out.println("Find by name " + name + ":{ ");
        while (rs.next())
            System.out.println("Id:" + rs.getInt("Id") +
                    ", name: " + rs.getString(2) + ", county: " + rs.getString(3));
        System.out.println("}");
    }
}
