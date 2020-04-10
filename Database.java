package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//singleton database class
public class Database {
    // static variable single_instance of type Database
    private static Database single_instance = null;

    // private constructor restricted to this class itself
    private Database() {
        //open connetion ?
    }

    // static method to create instance of Database class
    public static Database Database() {
        // To ensure only one instance is created
        if (single_instance == null) {
            single_instance = new Database();
        }
        return single_instance;
    }

  //connection to database
    public void connect() throws SQLException {
        String url = "jdbc:mysql://localhost/MusicAlbums";
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    url, "root", "********");
            this.operate(con);
        } catch (SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        } finally {
            if (con != null) {
                System.out.println("Conexiune reusita !");
                con.close();
            }
        }
    }

    //functionality test
    public void operate(Connection c) throws SQLException {
        ArtistController Ar = new ArtistController();
        AlbumController Al = new AlbumController();

        Ar.create("Eminem","Sua",c);
        Al.create("Astroworld",2,2019,c);
        Ar.findByName("Eminem",c);
        Al.findByArtist(2,c);
    }

}