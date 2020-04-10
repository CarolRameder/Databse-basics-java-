package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//handeles the interaction with artist table
public class ArtistController {

    public void create(String v_name, String v_country, Connection c) throws SQLException {
        String query="INSERT INTO artists (name ,country) VALUES ('" + v_name + "','" + v_country + "');" ;
        Statement st=c.createStatement();
        int count=st.executeUpdate(query);
        System.out.println(count+" number of rows were changed");
    }

    public void findByName(String v_name, Connection c) throws SQLException {
        String query="select * from artists where name = '" + v_name + "';" ;
        Statement st=c.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        String country=rs.getString(3);
        String id=rs.getString(1);
        System.out.println("The artist called " + v_name +" is from " + country + " and has id: " + id);
    }
}
