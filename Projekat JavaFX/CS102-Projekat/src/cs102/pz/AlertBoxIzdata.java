package cs102.pz;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class AlertBoxIzdata {

    public static void alert() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Knjiga je uspesno izdata!");
        alert.setTitle("Success!");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            RaspoloziveKnjige.sve();
            
            
        }
        
    }
}
