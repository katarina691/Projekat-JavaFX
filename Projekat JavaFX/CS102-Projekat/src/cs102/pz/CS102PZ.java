package cs102.pz;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CS102PZ extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button unos = new Button("Unos nove knjige");
        unos.setOnAction(e -> {
            Unos.unesi();
        });
        Button slobodne = new Button("Spisak raspolozivih knjiga");
        slobodne.setOnAction(e -> {
            RaspoloziveKnjige.sve();
        });
        Button izdate = new Button("Spisak izdatih knjiga");
        izdate.setOnAction(e -> {
            IzdateKnjige.sve();
        });

        VBox vb = new VBox();
        vb.setPadding(new Insets(15, 10, 10, 40));
        vb.setSpacing(20);
        vb.getChildren().addAll(unos, slobodne, izdate);

        Scene scene = new Scene(vb, 300, 250);

        primaryStage.setTitle("Pocetni meni");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }

}
