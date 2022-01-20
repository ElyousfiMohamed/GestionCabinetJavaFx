/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IMetier.ClassesPersistants;

import java.sql.Date;

/**
 *
 * @author ELYOUSFI
 */
public class Patient {
    private int id;
    private String nom;
    private String prenom;
    private String cin;
    private String telephone;
    private String email;
    private Date date_naissance;

    public Patient() {
    }

    public Patient(int id, String nom, String prenom, String cin, String telephone, String email, Date date_naissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.telephone = telephone;
        this.email = email;
        this.date_naissance = date_naissance;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    @Override
    public String toString() {
        return nom; //To change body of generated methods, choose Tools | Templates.
    }
    
    public Patient(String nom, String prenom, String cin, String telephone, String email, Date date_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.telephone = telephone;
        this.email = email;
        this.date_naissance = date_naissance;
    }

}
