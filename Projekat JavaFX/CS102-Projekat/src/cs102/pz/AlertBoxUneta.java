package cs102.pz;

import javafx.scene.control.Alert;


public class AlertBoxUneta {
     public static void alert() {

        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setHeaderText("Uspesno ste uneli knjigu!");
        al.setTitle("Success!");
        al.show();
    }
}
