package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Models.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Connect conexiondb = new Connect();
        conexiondb.connect();
        conexiondb.selectAll();
        Parent root = FXMLLoader.load(getClass().getResource("Views/table.fxml"));
        primaryStage.setTitle("Poker Tools");
        primaryStage.setScene(new Scene(root, 1156, 749));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
