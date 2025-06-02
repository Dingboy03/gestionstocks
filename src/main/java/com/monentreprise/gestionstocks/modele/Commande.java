package com.monentreprise.gestionstocks.modele;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Commande {
    private int idCommande;
    private String nomClient;
    private LocalDate dateCommande;
    private List<LigneCommande> lignes;

    // Constructeurs, getters, setters
    public Commande(int idCommande, String nomClient, LocalDate dateCommande, List<LigneCommande> lignes) {
        this.idCommande = idCommande;
        this.nomClient = nomClient;
        this.dateCommande = dateCommande;
        this.lignes = new ArrayList<>();
    }
    public int getIdCommande() {
        return idCommande;
    }
    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
    public String getNomClient() {
        return nomClient;
    }
    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }
    public LocalDate getDateCommande() {
        return dateCommande;
    }
    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }
    public List<LigneCommande> getLignes() {
        return lignes;
    }
    public void setLignes(List<LigneCommande> lignes) {
        this.lignes = lignes;
    }
    
}
