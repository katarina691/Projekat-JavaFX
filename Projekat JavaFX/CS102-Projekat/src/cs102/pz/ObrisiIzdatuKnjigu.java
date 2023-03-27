package cs102.pz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ObrisiIzdatuKnjigu {

    public static void obrisi() {

        Stage stage = new Stage();
        Button obrisi = new Button("Obrisi");
        TextField tf1 = new TextField();
        tf1.setMaxSize(50, 20);
        Label lb1 = new Label("Ukucajte ID knjige koju zelite obrisati iz tabele: ");
        //brisanje knjige iz tabele unosom IDa knjige i klikom na dugme obrisi
        obrisi.setOnAction(e -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteka", "root", "");
                Statement st = con.createStatement();

                PreparedStatement ps = con.prepareStatement("DELETE FROM IzdateKnjige WHERE ID = ?");

                ps.setString(1, tf1.getText());

                ps.execute();
                AlertBoxObrisiIzdatu.alert();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Unos.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        VBox vb1 = new VBox();
        vb1.setSpacing(9);
        vb1.getChildren().addAll(lb1, tf1, obrisi);
        StackPane sp = new StackPane();
        sp.setPadding(new Insets(10, 10, 10, 10));
        sp.getChildren().addAll(vb1);

        Scene scene = new Scene(sp, 350, 300);
        stage.setTitle("Obrisi knjigu");
        stage.setScene(scene);
        stage.show();

    }
}
