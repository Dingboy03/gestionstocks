package com.monentreprise.gestionstocks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.monentreprise.gestionstocks.modele.LigneCommande;


public class LigneCommandeImpl  implements LigneCommandeDAO {
    private Connection connection;
    public LigneCommandeImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void ajouter(LigneCommande ligneCommande) {
        String sql = "INSERT INTO LIGNE_COMMANDE (idLigne, idCommande, idProduit, quantite, prixUnitaire) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ligneCommande.getIdLigne());
            statement.setInt(2, ligneCommande.getIdCommande());
            statement.setInt(3, ligneCommande.getIdProduit());
            statement.setInt(4, ligneCommande.getQuantite());
            statement.setDouble(5, ligneCommande.getPrixUnitaire());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la ligne de commande : " + e.getMessage());
        }
    }

    @Override
    public void modifier(LigneCommande ligneCommande) {
        String sql = "UPDATE LIGNE_COMMANDE SET idCommande = ?, idProduit = ?, quantite = ?, prixUnitaire = ? WHERE idLigne = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ligneCommande.getIdCommande());
            statement.setInt(2, ligneCommande.getIdProduit());
            statement.setInt(3, ligneCommande.getQuantite());
            statement.setDouble(4, ligneCommande.getPrixUnitaire());
            statement.setInt(5, ligneCommande.getIdLigne());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de la ligne de commande : " + e.getMessage());
        }
    }

    @Override
    public void supprimer(int idLigneCommande) {
        String sql = "DELETE FROM LIGNE_COMMANDE WHERE idLigne = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idLigneCommande);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la ligne de commande : " + e.getMessage());
        }
    }

    @Override
    public LigneCommande findById(int idLigne) {
        String sql = "SELECT idLigne, idCommande, idProduit, quantite, prixUnitaire FROM LIGNE_COMMANDE WHERE idLigne = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idLigne);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new LigneCommande(
                    resultSet.getInt("idLigne"),
                    resultSet.getInt("idCommande"),
                    resultSet.getInt("idProduit"),
                    resultSet.getInt("quantite"),
                    resultSet.getDouble("prixUnitaire")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de la ligne de commande : " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<LigneCommande> findAllByIdCommande(int idCommande) {
        List<LigneCommande> lignes = new ArrayList<>();
        String sql = "SELECT idLigne, idCommande, idProduit, quantite, prixUnitaire FROM LIGNE_COMMANDE WHERE idCommande = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCommande);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lignes.add(new LigneCommande(
                    resultSet.getInt("idLigne"),
                    resultSet.getInt("idCommande"),
                    resultSet.getInt("idProduit"),
                    resultSet.getInt("quantite"),
                    resultSet.getDouble("prixUnitaire")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des lignes de commande : " + e.getMessage());
        }
        return lignes;
    }
}
