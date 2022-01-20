/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package IMetier;

import IMetier.ClassesPersistants.*;
import com.mysql.cj.xdevapi.Client;
import java.util.List;

/**
 *
 * @author ELYOUSFI
 */
public interface ICabinetMetier {
    //entite patient
    void addPatient(Patient p);
    List<Patient> getAllPatients();
    void delPatient(int id);
    List<Patient> searchPatient(String keyWord);
    List<Consultation> getAllPatientConsultations(int id);

    //entite medecin
    void addMedecin(Medecin m);
    List<Medecin> getAllMedecins();
    void delMedecin(int id);
    List<Medecin> searchMedecin(String keyWord);
    List<Consultation> getAllMedecinConsultations(int id);

    //entite medecin
    void addConsultation(Consultation c);
    List<Consultation> getAllConsultations();
    void delConsultation(int id);
    List<Consultation> searchConsultation(String keyWord);
}
