/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String SQLCONN = "jdbc:sqlite:src/app.sqlite";
    //connection to sqlite, no host when the db is copied in src
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(SQLCONN);
    }
}





//    public Connection connect() {
////        String url = "jdbc:mysql://localhost:3306/app";
////
////        String user = "root";
////        String password = "1am<MSQL!_+401";
//        Connection conn = null;
//        try {
//            // copy, paste reduce to databse name
//            //jdbc:mysql://localhost:3306/app?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]
//            // Class.forName("com.mysql.cj.jdbc.Driver"); // not necessary
//            conn = DriverManager.getConnection(url, user, password);
//            return conn;
//        } catch (SQLException ex) {
//            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return conn;
//    }