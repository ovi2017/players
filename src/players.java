import javafx.application.Application;
import javafx.scene.control.Dialog;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import java.util.Optional;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import javax.swing.*;


/**@author Ovidio Castillo
 *Purpose: To login to count how many players in a team
 *Date: 10/13/2017
 *License: GNU
 */

public class players extends Application {
    //key for verification
    private String masterUsername = "ovidio";
    private String masterPassword = "csc200";

    @Override
    public void start(Stage primaryStage) {
        //Sign In box for Use
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("MAKE YOUR TEAM");
        dialog.setHeaderText("You Must sign In to Use the Team Calculator");
        dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));
        //picture for the login screen
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        //button action
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        //data field
        TextField username = new TextField();
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        //input boxes
        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);
        //result converter
        dialog.getDialogPane().setContent(grid);
        dialog.setResultConverter(dialogButton -> {

            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result;
        do {
            result = dialog.showAndWait();
        } while (!result.get().getValue().equals(masterUsername) && !result.get().getValue().equals(masterPassword));
        //asks user input after successful login
        System.out.println("How many people are in your Group?");

        //Number of people in group logic
        double number = Double.parseDouble(JOptionPane.showInputDialog("Number of People"));
        //if and error
        if (number <= 10 && number >= 3) { //greater than 10 is divided by 2
            System.out.println("Your group consists of " + number / 3 + " People.");
        } else if (number > 10) {
            System.out.println("Your group consists of " + number / 2 + " People.");
        } else System.out.println("Your group must have at least 3 people.");
    }

    //number of Players in team logic
     public static void main(String [] args) {
        double player = Double.parseDouble(JOptionPane.showInputDialog("Number of Players"));

        if (player >= 11 && player <= 55) {
            System.out.println("Your Team Size is " + player / 11 + "Players.");
        }else{
                System.out.println("Your Team Size is 1.");
            }
        }
   }
