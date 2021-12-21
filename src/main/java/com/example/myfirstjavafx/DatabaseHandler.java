package com.example.myfirstjavafx;
import javafx.scene.control.CheckBox;

import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
          String connectionString="jdbc:mysql://"  + dbHost + ":" + dbPort + "/"+ dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,dbUser,dbPass);

        return dbConnection;
    }

    public void signUpUser(User user){
            String insert = "INSERT INTO " + Const.USER_TABLE + "("+ Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + ","+
            Const.USER_USERNAME + "," + Const.USER_PASSWORD + "," + Const.USER_LOCATION + "," + Const.USER_GENDER + ")" +
                    "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,user.getFirstName());
            prSt.setString(2,user.getLastName());
            prSt.setString(3,user.getUserName());
            prSt.setString(4,user.getPassword());
            prSt.setString(5,user.getLocation());
            prSt.setString(6, user.getGender());
            prSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String select = "Select * FROM users where username =? and password = ?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1,user.getUserName());
            prSt.setString(2,user.getPassword());
           resSet= prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
            return resSet;
    }


}



