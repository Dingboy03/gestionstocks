package com.monentreprise.gestionstocks.dao;
import java.util.List;

import com.monentreprise.gestionstocks.modele.LigneCommande;


public interface LigneCommandeDAO {
    void ajouter(LigneCommande ligneCommande);
    
    void modifier(LigneCommande ligneCommande);
    
    void supprimer(int idLigneCommande);
    
    LigneCommande findById(int idLigne);
    
    List<LigneCommande> findAllByIdCommande(int idCommande);
}
