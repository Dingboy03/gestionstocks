/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.monentreprise.gestionstocks.dao;

import java.util.List;

import com.monentreprise.gestionstocks.modele.Produit;

/**
 *
 * @author SCHIPHRA
 */
public interface ProduitDAO {
    // la on récupere la liste de tous les produits (par la categorie aussi) et on récupère un produit par son id
    List<Produit> findAll();
    Produit findById(int idProduit);
    List<Produit> findByCategorie(String categorie);

    // les méthodes pour ajouter, modifier et supprimer un produit
    void ajouter(Produit produit);
    void modifier(Produit produit);
    void supprimer(int idProduit);


}
