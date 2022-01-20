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
public class UpdatePatientController implements Initializable {

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
        this.cin.setText(ICabinetMetierImpl.patient.getCin());
        this.nom.setText(ICabinetMetierImpl.patient.getNom());
        this.prenom.setText(ICabinetMetierImpl.patient.getPrenom());
        this.telephone.setText(ICabinetMetierImpl.patient.getTelephone());
        this.email.setText(ICabinetMetierImpl.patient.getEmail());
    }

    @FXML
    private void UpdatePatient(ActionEvent event) {
        try {
            java.sql.Date date = Date.valueOf(dateNaissance.valueProperty().get());
            ICabinetMetier metier = new ICabinetMetierImpl();
            ICabinetMetierImpl.patient.setCin(this.cin.getText());
            ICabinetMetierImpl.patient.setNom(this.nom.getText());
            ICabinetMetierImpl.patient.setPrenom(this.prenom.getText());
            ICabinetMetierImpl.patient.setTelephone(this.telephone.getText());
            ICabinetMetierImpl.patient.setEmail(this.email.getText());
            ICabinetMetierImpl.patient.setDate_naissance(date);
            ICabinetMetierImpl.updatePatient();
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
