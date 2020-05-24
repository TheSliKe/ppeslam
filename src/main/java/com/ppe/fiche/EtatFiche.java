package com.ppe.fiche;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EtatFiche {

    private StringProperty etat;
    private StringProperty date;

    public EtatFiche(String etat, String date){

        this.etat =  new SimpleStringProperty(etat);;
        this.date =  new SimpleStringProperty(date);;

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
