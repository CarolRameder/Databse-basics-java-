package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        // write your code here

        Database myDB = Database.Database();
        myDB.connect();

    }
}
