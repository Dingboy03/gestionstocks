package com.monentreprise.gestionstocks.dao;
import java.util.List;

import com.monentreprise.gestionstocks.modele.Commande;


public interface CommandeDAO {
    // Méthode pour ajouter une commande
    void ajouter(Commande commande);

    // Méthode pour modifier une commande
    void modifier(Commande commande);

    // Méthode pour supprimer une commande par son ID
    void supprimer(int idCommande);

    // Méthode pour trouver une commande par son ID
    Commande findById(int idCommande);

    // Méthode pour récupérer toutes les commandes
    List<Commande> findAll();

    // Méthode pour récupérer les commandes d'un client spécifique
    List<Commande> findByNomClient(int nomClient);
}
