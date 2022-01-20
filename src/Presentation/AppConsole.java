/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentation;

import IMetier.ClassesPersistants.*;
import IMetier.*;
import java.sql.Date;

/**
 *
 * @author ELYOUSFI
 */
public class AppConsole {
    public static void main(String[] args) {
        Patient p1 = new Patient("ELYOUSFI", "Mohamed", "Q345897", "+212654789574", "mohamed@contact.me",new Date(04/05/2000));
        Medecin m1 = new Medecin("ELYOUSFI", "oussama", "+2126489865", "oussama@contact.me");
        
        ICabinetMetier metier = new ICabinetMetierImpl();
        metier.addPatient(p1);
        metier.addMedecin(m1);
        
        System.out.println(metier.getAllPatients());
        System.out.println(metier.getAllMedecins());


    }
}
