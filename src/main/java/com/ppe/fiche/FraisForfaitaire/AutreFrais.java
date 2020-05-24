package com.ppe.fiche.FraisForfaitaire;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AutreFrais {

    private StringProperty libelle;
    private StringProperty date;
    private StringProperty montant;
    private StringProperty justificatif;

    public AutreFrais(String libelle, String date, String montant, String justificatif){

        this.libelle = new SimpleStringProperty(libelle);
        this.date = new SimpleStringProperty(date);
        this.montant = new SimpleStringProperty(montant);
        this.justificatif = new SimpleStringProperty(justificatif);

    }

    public String getLibelle() {
        return libelle.get();
    }

    public StringProperty libelleProperty() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle.set(libelle);
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

    public String getMontant() {
        return montant.get();
    }

    public StringProperty montantProperty() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant.set(montant);
    }

    public String getJustificatif() {
        return justificatif.get();
    }

    public StringProperty justificatifProperty() {
        return justificatif;
    }

    public void setJustificatif(String justificatif) {
        this.justificatif.set(justificatif);
    }
}
