package cs102.pz;

import javafx.scene.control.Alert;


public class AlertBoxIdNePostoji {
    public static void alert() {

        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setHeaderText("ID koji ste uneli ne pripada nijednoj knjizi!");
        al.setTitle("Success!");
        al.show();
    }
}
