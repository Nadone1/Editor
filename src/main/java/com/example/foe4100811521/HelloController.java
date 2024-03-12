package com.example.foe4100811521;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HelloController implements Initializable {

    FileChooser choose = new FileChooser();

    @FXML
    private Button btnCancel;
    @FXML
    private Button btnCopy;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnLogin;

    @FXML
    private RadioButton rbnFemale;

    @FXML
    private RadioButton rbnMale;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnEdit;

    @FXML
    private TextField txtPhone;

    @FXML
    private Label lbldisplay;
    @FXML
    private MenuItem btnLogout;

    @FXML
    private MenuItem itemLogout;
    @FXML
    private Button btnSave;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void onCancel(ActionEvent event) {
        Platform.exit();

    }

    @FXML
    void onLogin(ActionEvent event) throws IOException {
        String name = txtUsername.getText();
        String password = txtPassword.getText();
        if (name.equals("Admin")&&password.equals("admin")){

            Stage login = (Stage) btnLogin.getScene().getWindow();
            login.close();


            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 667, 462);
            Stage stage= new Stage();
            stage.setTitle("Debtor App");
            stage.setScene(scene);
            stage.show();


        }else {
            lbldisplay.setTextFill(Color.RED);
            lbldisplay.setText("Invalid Logins Details");
        }

    }

    public void onExit(ActionEvent actionEvent) {
        Platform.exit();
    }
    @FXML

    void onCopy(ActionEvent event) {

    }


    public void onLogout(ActionEvent actionEvent) throws IOException {



        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 569, 388);
        Stage stage =new Stage();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();



    }

    public void onEdit(ActionEvent actionEvent) {
        txtArea.setEditable(true);

    }


    @FXML
    void onSave1(ActionEvent event) throws FileNotFoundException {
        File file = choose.showSaveDialog(new Stage());
        savesystem(file,txtArea.getText());
        txtArea.setText("");

    }

    public void onView(ActionEvent actionEvent) {
        File file = choose.showOpenDialog(new Stage());
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(scan.hasNextLine()){
            txtArea.appendText(scan.nextLine()+'\n');
        }

    }

    public void onSave(ActionEvent actionEvent) throws FileNotFoundException {
        File file = choose.showSaveDialog(new Stage());
        String gender = "";
        if (rbnFemale.isSelected()){
            gender= rbnFemale.getText();
        } else if (rbnMale.isSelected()) {
            gender= rbnMale.getText();

        }

        String name = txtName.getText()+'\n'+txtPhone.getText()+'\n'+txtAmount.getText()+'\n'+gender;
        savesystem(file,name);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void savesystem(File file, String content) throws FileNotFoundException {
        PrintWriter save = new PrintWriter(file);
        save.write(content);
        save.close();
    }
}
