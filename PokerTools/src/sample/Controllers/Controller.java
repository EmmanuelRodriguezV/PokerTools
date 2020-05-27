package sample.Controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class Controller implements Initializable {

    @FXML
    ComboBox<String > ComboSeleccionaFase;
    @FXML
            ComboBox<String> ComboSeleccionalugar;
    @FXML
            ComboBox<String> ComboCarta1;
    @FXML
            ComboBox<String >ComboCarta2;

    ObservableList<String>ObservableListlugares = FXCollections.observableArrayList("SB","BB","D","UTG","MP","CO");
    ObservableList<String>ObservableListpokerstates = FXCollections.observableArrayList("preflop","postflop","turn","river");
    ObservableList<String >ObservableListcards;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> cartas = new ArrayList<>();
        ArrayList<String> letras = new ArrayList<>();
        letras.add("spade ");
        letras.add("diamond ");
        letras.add("clover");
        letras.add("heart");
        for(String letra : letras)
        {
            cartas.add(letra + "Ace ");
            for(int i = 2 ; i <= 10 ;i ++)
                cartas.add(i +" "+ letra);
            cartas.add(letra + " Jack");
            cartas.add(letra +" Queen");
            cartas.add(letra + " King");
        }
        ObservableListcards = FXCollections.observableList(cartas);

        ComboCarta1.setItems(ObservableListcards);
        ComboCarta2.setItems(ObservableListcards);
        ComboSeleccionaFase.setItems(ObservableListpokerstates);
        ComboSeleccionalugar.setItems(ObservableListlugares);

    }
}
