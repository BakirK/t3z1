package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.*;

public class Controller {


    public javafx.scene.control.Button dugme;
    public ListView lista;
    public TextField digit;


    public void initialize() {
        digit.getStyleClass().add("poljeNijeIspravno");
        digit.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.isEmpty()) {
                    digit.getStyleClass().add("poljeNijeIspravno");
                    digit.setPromptText("Unesite broj");
                } else {
                    digit.getStyleClass().removeAll("poljeNijeIspravno");
                }
            }
        });
    }













    public static int sumacifara(int broj) {
        int suma = 0;
        while(broj !=0 ){
            suma = suma + (broj % 10);
            broj = broj / 10;
        }
        return suma;
    }

    public void Ispisi(ActionEvent actionEvent) {
        String n = digit.getText();


        for(int i = 1; i <= Integer.parseInt(n); i++){
            if(i % sumacifara(i)==0){
                lista.getItems().add(i);
            }
        }

    }
}
