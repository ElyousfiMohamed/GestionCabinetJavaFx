/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import IMetier.ClassesPersistants.*;
import IMetier.*;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author ELYOUSFI
 */
public class PatientController implements Initializable {

    @FXML
    private TableView<Patient> tableView = new TableView<>();
    @FXML
    private TableColumn<Patient, Integer> id;
    @FXML
    private TableColumn<Patient, String> cin;
    @FXML
    private TableColumn<Patient, String> nom;
    @FXML
    private TableColumn<Patient, String> prenom;
    @FXML
    private TableColumn<Patient, String> telephone;
    @FXML
    private TableColumn<Patient, String> email;
    @FXML
    private TextField rechercher;
    @FXML
    private TableColumn<Patient, Date> datenaissance;

    private ObservableList<Patient> patients = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ICabinetMetier metier = new ICabinetMetierImpl();
        patients.addAll(metier.getAllPatients());
        id.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("id"));
        cin.setCellValueFactory(new PropertyValueFactory<Patient, String>("cin"));
        nom.setCellValueFactory(new PropertyValueFactory<Patient, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Patient, String>("prenom"));
        telephone.setCellValueFactory(new PropertyValueFactory<Patient, String>("telephone"));
        email.setCellValueFactory(new PropertyValueFactory<Patient, String>("email"));
        datenaissance.setCellValueFactory(new PropertyValueFactory<Patient, Date>("date_naissance"));
        tableView.setItems(patients);
    }

    @FXML
    private void nouveau(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("NouveauPatient.fxml"));
            Scene scene = new Scene(loader.load());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Nouveau Patient");
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(
                    new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent e) {
                    tableView.getItems().clear();
                    ICabinetMetier metier = new ICabinetMetierImpl();
                    patients.addAll(metier.getAllPatients());
                    tableView.setItems(patients);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int indice = tableView.getSelectionModel().getSelectedIndex();
        if (indice >= 0) {
            try {
                ICabinetMetier metier = new ICabinetMetierImpl();
                metier.delPatient(tableView.getItems().get(indice).getId());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            tableView.getItems().remove(indice);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez s??lectionner un ??l??ment ");
            alert.show();
        }
    }

    @FXML
    private void rechercher(KeyEvent event) {
        String keyWord = rechercher.getText();
        tableView.getItems().clear();

        ICabinetMetier m = new ICabinetMetierImpl();
        patients.addAll(m.searchPatient(keyWord));
        tableView.setItems(patients);
    }

    @FXML
    private void modifier(ActionEvent event) {
        int indice = tableView.getSelectionModel().getSelectedIndex();
    if (indice >= 0) {
      try {
        ICabinetMetierImpl.patient = tableView.getItems().get(indice);

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("UpdatePatient.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("modifier client");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        stage.setOnCloseRequest(
                new EventHandler<WindowEvent>() {
                  @Override
                  public void handle(WindowEvent e) {
                    tableView.getItems().clear();
                    ICabinetMetier metier = new ICabinetMetierImpl();
                    patients.addAll(metier.getAllPatients());
                    tableView.setItems(patients);
                  }
                });
      } catch (Exception ex) {
        ex.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(ex.getMessage());
        alert.show();
      }
    } else {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setContentText("Veuillez s??lectionner un ??l??ment ");
      alert.show();
    }
    }

}
