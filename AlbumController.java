package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//handeles the interaction with album table
public class AlbumController {

    public void create(String name, int artistId, int releaseYear, Connection c) throws SQLException {
        String query="INSERT INTO albums (name ,artist_id,release_year ) VALUES ('" + name + "','" + artistId +  "','" + releaseYear +"');" ;
        Statement st=c.createStatement();
        int count=st.executeUpdate(query);
        System.out.println(count+" number of rows were changed");
    }
    public void findByArtist(int artistId, Connection c) throws SQLException {
        String query="select * from albums where artist_id = " + artistId + ";" ;
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        String name=rs.getString(2);
        int releaseYear=rs.getInt(4);
        System.out.println("The album called " + name +" was released in " + releaseYear );
    }
}
