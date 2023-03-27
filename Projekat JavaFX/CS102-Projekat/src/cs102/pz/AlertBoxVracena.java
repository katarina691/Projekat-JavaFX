package cs102.pz;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class AlertBoxVracena {
    public static void alert() {

        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setHeaderText("Knjiga je uspesno vracena!");
        al.setTitle("Success!");
        
         Optional<ButtonType> result = al.showAndWait();
        if (result.get() == ButtonType.OK) {
            IzdateKnjige.sve();
            
        }
    }
}
