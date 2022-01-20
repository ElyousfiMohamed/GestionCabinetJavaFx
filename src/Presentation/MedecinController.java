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
public class MedecinController implements Initializable {

    @FXML
    private TableView<Medecin> tableView = new TableView<>();
    @FXML
    private TableColumn<Medecin, Integer> id;
    @FXML
    private TableColumn<Medecin, String> cin;
    @FXML
    private TableColumn<Medecin, String> nom;
    @FXML
    private TableColumn<Medecin, String> prenom;
    @FXML
    private TableColumn<Medecin, String> telephone;
    @FXML
    private TableColumn<Medecin, String> email;
    @FXML
    private TextField rechercher;

    private ObservableList<Medecin> medecins = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ICabinetMetier metier = new ICabinetMetierImpl();
        medecins.addAll(metier.getAllMedecins());
        id.setCellValueFactory(new PropertyValueFactory<Medecin, Integer>("id"));
        cin.setCellValueFactory(new PropertyValueFactory<Medecin, String>("cin"));
        nom.setCellValueFactory(new PropertyValueFactory<Medecin, String>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<Medecin, String>("prenom"));
        telephone.setCellValueFactory(new PropertyValueFactory<Medecin, String>("telephone"));
        email.setCellValueFactory(new PropertyValueFactory<Medecin, String>("email"));
        tableView.setItems(medecins);
    }

    @FXML
    private void nouveau(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("NouveauMedecin.fxml"));
            Scene scene = new Scene(loader.load());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Nouveau Medecin");
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(
                    new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent e) {
                    tableView.getItems().clear();
                    ICabinetMetier metier = new ICabinetMetierImpl();
                    medecins.addAll(metier.getAllMedecins());
                    tableView.setItems(medecins);
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
                metier.delMedecin(tableView.getItems().get(indice).getId());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            tableView.getItems().remove(indice);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un élément ");
            alert.show();
        }
    }

    @FXML
    private void rechercher(KeyEvent event) {
        String keyWord = rechercher.getText();
        tableView.getItems().clear();

        ICabinetMetier m = new ICabinetMetierImpl();
        medecins.addAll(m.searchMedecin(keyWord));
        tableView.setItems(medecins);
    }

    @FXML
    private void modifier(ActionEvent event) {
        int indice = tableView.getSelectionModel().getSelectedIndex();
    if (indice >= 0) {
      try {
        ICabinetMetierImpl.medecin = tableView.getItems().get(indice);

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("UpdateMedecin.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("modifier Medecin");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        stage.setOnCloseRequest(
                new EventHandler<WindowEvent>() {
                  @Override
                  public void handle(WindowEvent e) {
                    tableView.getItems().clear();
                    ICabinetMetier metier = new ICabinetMetierImpl();
                    medecins.addAll(metier.getAllMedecins());
                    tableView.setItems(medecins);
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
      alert.setContentText("Veuillez sélectionner un élément ");
      alert.show();
    }
    }

}
