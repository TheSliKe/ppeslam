package com.ppe.fiche.FraisForfaitaire;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Frais {

    private StringProperty nom;
    private StringProperty quantite;
    private StringProperty prixUnitaire;
    private StringProperty total;

    public Frais(String nom, String quantite, String prixUnitaire, String total){

        this.nom = new SimpleStringProperty(nom);
        this.quantite = new SimpleStringProperty(quantite);
        this.prixUnitaire = new SimpleStringProperty(prixUnitaire);
        this.total = new SimpleStringProperty(total);

    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getQuantite() {
        return quantite.get();
    }

    public StringProperty quantiteProperty() {
        return quantite;
    }

    public void setQuantite(String quantité) {
        this.quantite.set(quantité);
    }

    public String getPrixUnitaire() {
        return prixUnitaire.get();
    }

    public StringProperty prixUnitaireProperty() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(String prixUnitaire) {
        this.prixUnitaire.set(prixUnitaire);
    }

    public String getTotal() {
        return total.get();
    }

    public StringProperty totalProperty() {
        return total;
    }

    public void setTotal(String total) {
        this.total.set(total);
    }
}
