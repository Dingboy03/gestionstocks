package com.monentreprise.gestionstocks.modele;

public class Facture {
    private int id;
    private int idCommande;
    private double montantTotal;

    // Constructeurs, getters, setters
    public Facture(int id, int idCommande, double montantTotal) {
        this.id = id;
        this.idCommande = idCommande;
        this.montantTotal = montantTotal;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdCommande() {
        return idCommande;
    }
    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
    public double getMontantTotal() {
        return montantTotal;
    }
    
}
