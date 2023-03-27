package cs102.pz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class IzdateKnjige {

    public static void sve() {
        /*
        kada je knjiga prebacena u drugu tabelu prikazuje se alert koji nas obavestava 
        da je knjiga prebacena i klikom na dugme ok na alertu otvara se novi prozor 
        spisak izdatih knjiga, na kome ponovo mozemo izabrati neku od opcija.
        Novi prozor se otvara da bi se tabela osvezila i prikazala spisak bez 
        vracenje knjige.
         */
       
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteka", "root", "");
            Statement st = con.createStatement();
            System.out.println("Uspesno povezano");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Nije uspelo povezivanje");
        }

        //pravljenje tabele
        TableView tv = new TableView();

        TableColumn<Integer, Knjiga> column0 = new TableColumn<>("ID");
        column0.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<String, Knjiga> column1 = new TableColumn<>("Naziv");
        column1.setCellValueFactory(new PropertyValueFactory<>("naziv"));

        TableColumn<String, Knjiga> column2 = new TableColumn<>("Autor");
        column2.setCellValueFactory(new PropertyValueFactory<>("autor"));

        TableColumn<String, Knjiga> column3 = new TableColumn<>("Godina izdanja");
        column3.setCellValueFactory(new PropertyValueFactory<>("godinaIzdanja"));

        tv.getColumns().addAll(column0, column1, column2, column3);
        //iscitavanje iz baze i ubacivanje u tabelu
        try {
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/biblioteka", "root", "");
            Statement st = con.createStatement();
            String query = "SELECT * FROM IzdateKnjige";
            rs = st.executeQuery(query);
            System.out.println("Uspesno iscitano");
            while (rs.next()) {

                tv.getItems().addAll(new Knjiga(rs.getInt("ID"), rs.getString("naziv"), rs.getString("autor"), rs.getString("godina")));

            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Nema izdatih knjiga");
        }
        
        
        Button obrisi = new Button("Obrisi knjigu iz tabele izdatih knjiga");
        //brisanje knjige
        obrisi.setOnAction((ActionEvent e) -> {
            ObrisiIzdatuKnjigu.obrisi();     
        });
        
        Button vrati = new Button("Vrati knjigu u biblioteku");
        //vracanje knjige
        vrati.setOnAction(e -> {
            VracanjeKnjige.prebaci();
        });
        
        Stage stage = new Stage();
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.getChildren().addAll(vrati, obrisi);
        BorderPane bp = new BorderPane();
        bp.setCenter(tv);
        bp.setBottom(hb);

        Scene scene = new Scene(bp, 900, 500);
        stage.setTitle("Spisak izdatih knjiga");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }

}
