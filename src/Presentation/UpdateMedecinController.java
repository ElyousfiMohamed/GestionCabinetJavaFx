/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Presentation;

import IMetier.ICabinetMetier;
import IMetier.ICabinetMetierImpl;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ELYOUSFI
 */
public class UpdateMedecinController implements Initializable {

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
        this.nom.setText(ICabinetMetierImpl.medecin.getNom());
        this.prenom.setText(ICabinetMetierImpl.medecin.getPrenom());
        this.telephone.setText(ICabinetMetierImpl.medecin.getTelephone());
        this.email.setText(ICabinetMetierImpl.medecin.getEmail());
    }

    @FXML
    private void UpdatePatient(ActionEvent event) {
        try {
            ICabinetMetier metier = new ICabinetMetierImpl();
            ICabinetMetierImpl.medecin.setNom(this.nom.getText());
            ICabinetMetierImpl.medecin.setPrenom(this.prenom.getText());
            ICabinetMetierImpl.medecin.setTelephone(this.telephone.getText());
            ICabinetMetierImpl.medecin.setEmail(this.email.getText());
            ICabinetMetierImpl.updateMedecin();
            Stage stage = (Stage) rootPane.getScene().getWindow();
            stage.close();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }

    @FXML
    private void annuler(ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

}
