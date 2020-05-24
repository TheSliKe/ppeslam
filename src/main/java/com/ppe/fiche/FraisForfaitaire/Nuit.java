package com.ppe.fiche.FraisForfaitaire;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Nuit {

    private StringProperty qNuit;
    private StringProperty puNuit;
    private StringProperty totalNuit;

    public Nuit(int qNuit, int puNuit){

        this.qNuit = new SimpleStringProperty(Integer.toString(qNuit));
        this.puNuit = new SimpleStringProperty(Integer.toString(puNuit));

        this.totalNuit = new SimpleStringProperty(Integer.toString(qNuit * puNuit));
    }

    public String getqNuit() {
        return qNuit.get();
    }

    public StringProperty qNuitProperty() {
        return qNuit;
    }

    public void setqNuit(String qNuit) {
        this.qNuit.set(qNuit);
    }

    public String getPuNuit() {
        return puNuit.get();
    }

    public String puNuitProperty() {
        return puNuit.get();
    }

    public void setPuNuit(String puNuit) {
        this.puNuit.set(puNuit);
    }

    public String getTotalNuit() {
        return totalNuit.get();
    }

    public String totalNuitProperty() {
        return totalNuit.get();
    }

    public void setTotalNuit(String totalNuit) {
        this.totalNuit.set(totalNuit);
    }
}
