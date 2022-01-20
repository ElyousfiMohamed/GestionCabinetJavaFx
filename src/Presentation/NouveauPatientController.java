/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Presentation;

import IMetier.ClassesPersistants.Patient;
import IMetier.ICabinetMetier;
import IMetier.ICabinetMetierImpl;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ELYOUSFI
 */
public class NouveauPatientController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField cin;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField telephone;
    @FXML
    private TextField email;
    @FXML
    private DatePicker dateNaissance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     @FXML
  void annuler(ActionEvent event) {
    Stage stage = (Stage) rootPane.getScene().getWindow();
    stage.close();
  }

  @FXML
  void NouveauPatient(ActionEvent event) {
    try {
      java.sql.Date date = Date.valueOf(dateNaissance.valueProperty().get());
      ICabinetMetier metier = new ICabinetMetierImpl();
      Patient c =
          new Patient(
              this.cin.getText(),
              this.nom.getText(),
              this.prenom.getText(),
              this.telephone.getText(),
              this.email.getText(),
              date);
      metier.addPatient(c);
      this.cin.clear();
      this.nom.clear();
      this.prenom.clear();
      this.telephone.clear();
      this.email.clear();
      this.dateNaissance.valueProperty().set(null);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
    
}
