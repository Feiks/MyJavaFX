package com.example.myfirstjavafx;

import com.example.myfirstjavafx.Shake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private Button LoginButton;

    @FXML
    private TextField PasswordField;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField loginField;

    @FXML
    void ButtonClicked(ActionEvent event) {
        String loginText = loginField.getText().trim();
        String passwordText = PasswordField.getText().trim();

        if(!loginText.equals("") && !passwordText.equals("")){
            loginUser(loginText,passwordText);

        }
        else{
            System.out.println("login and password is empty ERROR");
        }



    }

    private void loginUser(String loginText, String passwordText) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(passwordText);
       ResultSet result=  dbHandler.getUser(user);

       int counter = 0;
       while(true) {
           try {
               if (!result.next()) break;
           } catch (SQLException e) {
               e.printStackTrace();
           }
           counter++;
           if (counter >= 1)
               System.out.println("Success !");


           else {
               System.out.println("Boombom");
               /*Shake userloginAnim = new Shake(loginField);
               Shake userPasswordAnim = new Shake(PasswordField);
               userloginAnim.playAnim();
               userPasswordAnim.playAnim();*/
           }
       }
    }


    @FXML
    void SignUpClicked(ActionEvent event) {
        SignUpButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Signup.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

}
