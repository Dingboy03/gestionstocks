package com.monentreprise.gestionstocks.modele;

public class Produit {
    private int idProduit;
    private String nom;
    private String categorie;
    private double prixUnitaire;
    private int quantiteStock;

    // Constructeurs, getters, setters
    public Produit() {
        // Constructeur par défaut
    }
// Constructors
    public Produit(int idProduit, String nom, String categorie, double prixUnitaire, int quantiteStock) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.categorie = categorie;
        this.prixUnitaire = prixUnitaire;
        this.quantiteStock = quantiteStock;
    }

    // Getters and Setters
    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }
}