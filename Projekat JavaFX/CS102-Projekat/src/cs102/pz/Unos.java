package cs102.pz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Unos {
     public static void unesi() {
         
    Stage stage = new Stage();
        Label naziv = new Label("Naziv");
        Label autor = new Label("Autor");
        Label godinaIzdanja = new Label("Godina izdanja");
        
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        Button unesi = new Button("Unesi");
        //upisivanje u bazu podataka klikom na dugme unesi pomocu preparedStatement
        unesi.setOnAction((ActionEvent e) -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteka", "root", "");
                Statement st = con.createStatement();

                PreparedStatement ps = con.prepareStatement("INSERT INTO raspoloziveknjige (naziv, autor, godina) VALUES(?, ?, ?)");

                ps.setString(1, tf1.getText().substring(0,1).toUpperCase()+tf1.getText().substring(1));
                ps.setString(2, tf2.getText().substring(0,1).toUpperCase()+tf2.getText().substring(1));
                ps.setString(3, tf3.getText());

                ps.execute();
                AlertBoxUneta.alert();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Unos.class.getName()).log(Level.SEVERE, null, ex);
            }            
            stage.close();
    });

        HBox hb1 = new HBox(15);
        hb1.getChildren().addAll(naziv, tf1);
        HBox hb2 = new HBox(15);
        hb2.getChildren().addAll(autor, tf2);
        HBox hb3 = new HBox(15);
        hb3.getChildren().addAll(godinaIzdanja, tf3);
        

        VBox vb1 = new VBox(20);
        vb1.getChildren().addAll(hb1, hb2, hb3, unesi);
        vb1.setPadding(new Insets(15, 10, 10, 40));
        vb1.setAlignment(Pos.CENTER);
        StackPane sp = new StackPane();
        sp.getChildren().addAll(vb1);

        Scene scene = new Scene(sp, 350, 300);
        stage.setTitle("Unos knjige");
        stage.setScene(scene);
        stage.show();
}
}
