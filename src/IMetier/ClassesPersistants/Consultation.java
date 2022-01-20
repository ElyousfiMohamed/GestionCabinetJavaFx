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
public class Consultation {
    private int id;
    private Date date_consultation;
    private Patient patient;
    private Medecin medecin;

    public Consultation() {
    }

    public Consultation(int id, Date date_consultation) {
        this.id = id;
        this.date_consultation = date_consultation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_consultation() {
        return date_consultation;
    }

    public void setDate_consultation(Date date_consultation) {
        this.date_consultation = date_consultation;
    }

    public Consultation(Date date_consultation) {
        this.date_consultation = date_consultation;
    }
    
    
    
}
