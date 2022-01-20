/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Presentation;

import IMetier.ClassesPersistants.Medecin;
import IMetier.ClassesPersistants.Patient;
import IMetier.ICabinetMetier;
import IMetier.ICabinetMetierImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ELYOUSFI
 */
public class NouveauMedecinController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField telephone;
    @FXML
    private TextField email;

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
  void NouveauMedecin(ActionEvent event) {
    try {
      ICabinetMetier metier = new ICabinetMetierImpl();
      Medecin c =
          new Medecin(
              this.nom.getText(),
              this.prenom.getText(),
              this.telephone.getText(),
              this.email.getText());
      metier.addMedecin(c);
      this.nom.clear();
      this.prenom.clear();
      this.telephone.clear();
      this.email.clear();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
    
}
