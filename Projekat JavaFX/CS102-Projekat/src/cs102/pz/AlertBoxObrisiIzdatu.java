package cs102.pz;

import javafx.scene.control.Alert;


public class AlertBoxObrisiIzdatu{
     public static void alert() {

        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setHeaderText("Uspesno ste izbrisali knjigu iz tabele izdatih knjiga!");
        al.setTitle("Success!");
        al.show();
    }
}
