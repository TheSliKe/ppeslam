package com.ppe.fiche;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fiche {

    public StringProperty matricule;
    public StringProperty etat;
    public StringProperty date;


    public Fiche() {
        this.matricule = null;
        this.etat = null;
        this.date = null;
    }

    public Fiche(String matricule, String etat, String date) {
        this.matricule = new SimpleStringProperty(matricule);
        this.etat = new SimpleStringProperty(etat);
        this.date = new SimpleStringProperty(date);
    }

    public String getMatricule() {
        return matricule.get();
    }

    public StringProperty matriculeProperty() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule.set(matricule);
    }

    public String getEtat() {
        return etat.get();
    }

    public StringProperty etatProperty() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat.set(etat);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }
}
