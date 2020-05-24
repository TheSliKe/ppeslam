package com.ppe.fiche.FraisForfaitaire;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Repas {

    private StringProperty qRepas;
    private StringProperty puRepas;
    private StringProperty totalRepas;

    public Repas(int qRepas, int puRepas){

        this.qRepas = new SimpleStringProperty(Integer.toString(qRepas));
        this.puRepas = new SimpleStringProperty(Integer.toString(puRepas));

        this.totalRepas = new SimpleStringProperty(Integer.toString(qRepas * puRepas));

    }

    public String getqRepas() {
        return qRepas.get();
    }

    public StringProperty qRepasProperty() {
        return qRepas;
    }

    public void setqRepas(String qRepas) {
        this.qRepas.set(qRepas);
    }

    public String getPuRepas() {
        return puRepas.get();
    }

    public StringProperty puRepasProperty() {
        return puRepas;
    }

    public void setPuRepas(String puRepas) {
        this.puRepas.set(puRepas);
    }

    public String getTotalRepas() {
        return totalRepas.get();
    }

    public StringProperty totalRepasProperty() {
        return totalRepas;
    }

    public void setTotalRepas(String totalRepas) {
        this.totalRepas.set(totalRepas);
    }
}
