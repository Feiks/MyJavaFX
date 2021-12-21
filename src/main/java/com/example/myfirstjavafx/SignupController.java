package com.example.myfirstjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class SignupController {

    @FXML
    private TextField PasswordField;

    @FXML
    private TextField PasswordField1;

    @FXML
    private Button SignupButtonid;

    @FXML
    private TextField loginField;


    @FXML
    private CheckBox signupCheckBoxMale;

    @FXML
    private TextField signupLastName;

    @FXML
    private TextField signupName;

    @FXML
    void ButtonClicked(ActionEvent event) {

        signUpNewUser();

    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = signupName.getText();
        String lastName = signupLastName.getText();
        String userName = loginField.getText();
        String password = PasswordField.getText();
        String location = PasswordField1.getText();
        String gender = "";
        if(signupCheckBoxMale.isSelected()){
            gender = "Мужской";
                    }
        else{
            gender = "Женский";
        }
        User user = new User(firstName,lastName,userName,password,location,gender);

        dbHandler.signUpUser(user);
    }

    @FXML
    void signupCountry(ActionEvent event) {

    }


}
