package cs102.pz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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


public class VracanjeKnjige {

    public static void prebaci() {
        Stage stage = new Stage();
        Button vrati = new Button("Vrati knjigu");
        TextField tf1 = new TextField();
        tf1.setMaxSize(50, 20);

        Label lb1 = new Label("Ukucajte ID knjige koju zelite vratiti na stanje: ");
        //prebacivanje knjige u tabelu raspoloziveKnjige unosom ida knjige i klikom na dugme vrati
        vrati.setOnAction(e -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteka", "root", "");

                ResultSet rs;

                PreparedStatement ps = con.prepareStatement("SELECT * FROM izdateknjige WHERE ID = ?");
                ps.setString(1, tf1.getText());

                rs = ps.executeQuery();
                if (rs.next()) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");

                        PreparedStatement ps1 = con.prepareStatement("INSERT INTO raspoloziveknjige SELECT * FROM izdateknjige WHERE ID = ?");

                        PreparedStatement ps2 = con.prepareStatement("DELETE FROM izdateknjige WHERE ID = ?");

                        ps1.setString(1, tf1.getText());
                        ps2.setString(1, tf1.getText());

                        ps1.execute();
                        ps2.execute();
                        AlertBoxVracena.alert();
                    } catch (SQLException | ClassNotFoundException ex) {
                        Logger.getLogger(Unos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    AlertBoxIdNePostoji.alert();
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(IzdavanjeKnjige.class.getName()).log(Level.SEVERE, null, ex);

            }

        });

        VBox vb1 = new VBox();
        vb1.setSpacing(10);

        vb1.setPadding(new Insets(10, 10, 10, 10));
        vb1.getChildren().addAll(lb1, tf1, vrati);
        StackPane sp = new StackPane();
        sp.getChildren().addAll(vb1);

        Scene scene = new Scene(sp, 350, 300);
        stage.setTitle("Vrati knjigu");
        stage.setScene(scene);
        stage.show();
    }
}
