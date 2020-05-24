package com.ppe.fiche.FraisForfaitaire;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Kilometre {

    private StringProperty qKilometre;
    private StringProperty puKilometre;
    private StringProperty totalKilometre;

    public Kilometre(int qKilometre, int puKilometre){

        this.qKilometre = new SimpleStringProperty(Integer.toString(qKilometre));
        this.puKilometre = new SimpleStringProperty(Integer.toString(puKilometre));

        this.totalKilometre = new SimpleStringProperty(Integer.toString(qKilometre * puKilometre));

    }

    public String getqKilometre() {
        return qKilometre.get();
    }

    public StringProperty qKilometreProperty() {
        return qKilometre;
    }

    public void setqKilometre(String qKilometre) {
        this.qKilometre.set(qKilometre);
    }

    public String getPuKilometre() {
        return puKilometre.get();
    }

    public StringProperty puKilometreProperty() {
        return puKilometre;
    }

    public void setPuKilometre(String puKilometre) {
        this.puKilometre.set(puKilometre);
    }

    public String getTotalKilometre() {
        return totalKilometre.get();
    }

    public StringProperty totalKilometreProperty() {
        return totalKilometre;
    }

    public void setTotalKilometre(String totalKilometre) {
        this.totalKilometre.set(totalKilometre);
    }
}
