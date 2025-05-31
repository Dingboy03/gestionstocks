package com.monentreprise.gestionstocks.modele;

public class LigneCommande {
    private int idLigne;
    private int idCommande;
    private int idProduit;
    private int quantite;
    private double prixUnitaire;
    private double sousTotal;

    // Constructeurs, getters, setters
    public LigneCommande(int idLigne, int idCommande, int idProduit, int quantite, double prixUnitaire) {
        this.idLigne = idLigne;
        this.idCommande = idCommande;
        this.idProduit = idProduit;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.sousTotal = quantite * prixUnitaire;
    }
    public int getIdLigne() {
        return idLigne;
    }
    public void setIdLigne(int idLigne) {
        this.idLigne = idLigne;
    }
    public int getIdCommande() {
        return idCommande;
    }
    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
    public int getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
        this.sousTotal = quantite * prixUnitaire; // Mettre à jour le sous-total
    }
    public double getPrixUnitaire() {
        return prixUnitaire;
    }
    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
        this.sousTotal = quantite * prixUnitaire; // Mettre à jour le sous-total
    }
    public double getSousTotal() {
        return sousTotal;
    }
    public void setSousTotal(double sousTotal) {
        this.sousTotal = sousTotal;
    }
    
}
