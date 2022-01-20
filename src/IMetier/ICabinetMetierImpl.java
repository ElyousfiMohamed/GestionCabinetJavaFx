/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IMetier;

import DataBaseConnexion.SingletonConnexionDB;
import IMetier.ClassesPersistants.Consultation;
import IMetier.ClassesPersistants.Medecin;
import IMetier.ClassesPersistants.Patient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author ELYOUSFI
 */
public class ICabinetMetierImpl implements ICabinetMetier {

    static private Connection conn;
    static public Patient patient;    
    static public Medecin medecin;
    static public Consultation consultation;


    public ICabinetMetierImpl() {
        conn = SingletonConnexionDB.getConnection();
    }

    @Override
    public void addPatient(Patient p) {
        try {
            Statement pstn = conn.createStatement();
            pstn.executeUpdate(
                    "INSERT INTO patient(NOM_PATIENT,PRENOM_PATIENT,CIN_PATIENT,TELEPHONE_PATIENT,EMAIL_PATIENT,DATE_NAISSANCE) VALUES "
                    + "('"
                    + p.getNom()
                    + "','"
                    + p.getPrenom()
                    + "','"
                    + p.getCin()
                    + "','"
                    + p.getTelephone()
                    + "','"
                    + p.getEmail()
                    + "','"
                    + p.getDate_naissance()
                    + "')");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Patient ajouté avec succés");
            alert.show();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try {
            Statement pstn = conn.createStatement();
            ResultSet rs = pstn.executeQuery("SELECT * FROM patient");
            while (rs.next()) {
                Patient p
                        = new Patient(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getDate(7));
                patients.add(p);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        return patients;
    }

    @Override
    public void delPatient(int id) {
        try {
            Connection conn = SingletonConnexionDB.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM patient WHERE ID_PATIENT=" + id);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Patient supprimé avec succés");
            alert.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    @Override
    public List<Patient> searchPatient(String keyWord) {
        List<Patient> patients = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs
                    = stm.executeQuery("SELECT * FROM patient WHERE NOM_PATIENT LIKE '%" + keyWord + "%'");
            while (rs.next()) {
                Patient p
                        = new Patient(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getDate(7));
                patients.add(p);
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.show();
        }
        return patients;
    }

    @Override
    public List<Consultation> getAllPatientConsultations(int id) {
        List<Consultation> consultations = new ArrayList<>();
        try {
            Statement pstn = conn.createStatement();
            ResultSet rs = pstn.executeQuery("SELECT * FROM consultation WHERE ID_PATIENT='"+id+"'");
            while (rs.next()) {
                Consultation c
                        = new Consultation(
                                rs.getInt(1),
                                rs.getDate(4));

                c.setPatient(getPatientById(rs.getInt(2)));
                c.setMedecin(getMedecinById(rs.getInt(3)));
                consultations.add(c);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        return consultations;
    }

    @Override
    public void addMedecin(Medecin m) {
        try {
            Statement pstn = conn.createStatement();
            pstn.executeUpdate(
                    "INSERT INTO medecin(NOM_MEDECIN,PRENOM_MEDECIN,EMAIL_MEDECIN,TELE_MEDECIN) VALUES "
                    + "('"
                    + m.getNom()
                    + "','"
                    + m.getPrenom()
                    + "','"
                    + m.getEmail()
                    + "','"
                    + m.getTelephone()
                    + "')");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Medecin ajouté avec succés");
            alert.show();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }

    @Override
    public List<Medecin> getAllMedecins() {
        List<Medecin> medecins = new ArrayList<>();
        try {
            Statement pstn = conn.createStatement();
            ResultSet rs = pstn.executeQuery("SELECT * FROM medecin");
            while (rs.next()) {
                Medecin m
                        = new Medecin(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5));
                medecins.add(m);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        return medecins;
    }

    @Override
    public void delMedecin(int id) {
        try {
            Connection conn = SingletonConnexionDB.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM medecin WHERE ID_MEDECIN=" + id);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Medecin supprimé avec succés");
            alert.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    @Override
    public List<Medecin> searchMedecin(String keyWord) {
        List<Medecin> medecins = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs
                    = stm.executeQuery("SELECT * FROM medecin WHERE NOM_MEDECIN LIKE '%" + keyWord + "%'");
            while (rs.next()) {
                Medecin m
                        = new Medecin(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5));
                medecins.add(m);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        return medecins;
    }

    @Override
    public List<Consultation> getAllMedecinConsultations(int id
    ) {
        List<Consultation> consultations = new ArrayList<>();
        try {
            Statement pstn = conn.createStatement();
            ResultSet rs = pstn.executeQuery("SELECT * FROM consultation WHERE ID_MEDECIN='"+id+"'");
            while (rs.next()) {
                Consultation c
                        = new Consultation(
                                rs.getInt(1),
                                rs.getDate(4));

                c.setPatient(getPatientById(rs.getInt(2)));
                c.setMedecin(getMedecinById(rs.getInt(3)));
                consultations.add(c);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        return consultations;
    }

    @Override
    public void addConsultation(Consultation c
    ) {
        try {
            Statement pstn = conn.createStatement();
            pstn.executeUpdate(
                    "INSERT INTO consultation(ID_PATIENT,ID_MEDECIN,DATE_CONSULTATION) VALUES "
                    + "('"
                    + c.getPatient().getId()
                    + "','"
                    + c.getMedecin().getId()
                    + "','"
                    + c.getDate_consultation()
                    + "')");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Consultation ajouté avec succés");
            alert.show();
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }

    @Override
    public List<Consultation> getAllConsultations() {
        List<Consultation> consultations = new ArrayList<>();
        try {
            Statement pstn = conn.createStatement();
            ResultSet rs = pstn.executeQuery("SELECT * FROM consultation");
            while (rs.next()) {
                Consultation c
                        = new Consultation(
                                rs.getInt(1),
                                rs.getDate(4));

                c.setPatient(getPatientById(rs.getInt(2)));
                c.setMedecin(getMedecinById(rs.getInt(3)));
                consultations.add(c);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        return consultations;
    }

    @Override
    public void delConsultation(int id
    ) {
        try {
            Connection conn = SingletonConnexionDB.getConnection();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM consultation WHERE ID_CONSULTATION=" + id);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Consultation supprimé avec succés");
            alert.show();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }

    @Override
    public List<Consultation> searchConsultation(String keyWord
    ) {
        List<Consultation> consultations = new ArrayList<>();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs
                    = stm.executeQuery("SELECT * FROM medecin WHERE NOM_MEDECIN LIKE '%" + keyWord + "%'");
            while (rs.next()) {
                Consultation c
                        = new Consultation(
                                rs.getInt(1),
                                rs.getDate(4));

                c.setPatient(getPatientById(rs.getInt(2)));
                c.setMedecin(getMedecinById(rs.getInt(3)));
                consultations.add(c);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        return consultations;
    }

    static Patient getPatientById(int id) {
        Patient patient = new Patient();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM patient WHERE ID_PATIENT = '" + id + "'");
            if (rs.next()) {
                patient
                        = new Patient(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getDate(7));
                return patient;
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.show();
        }
        return patient;
    }

    static Medecin getMedecinById(int id) {
        Medecin medecin = new Medecin();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM patient WHERE ID_PATIENT = '" + id + "'");
            if (rs.next()) {
                medecin
                        = new Medecin(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5));
                return medecin;
            }
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.show();
        }
        return medecin;
    }

}
