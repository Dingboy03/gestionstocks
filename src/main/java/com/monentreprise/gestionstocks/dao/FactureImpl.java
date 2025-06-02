package com.monentreprise.gestionstocks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.monentreprise.gestionstocks.modele.Facture;

public class FactureImpl implements FactureDAO {
    Connection connection;
    public FactureImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void ajouter(Facture facture) {
        String sql = "INSERT INTO FACTURE (id, idCommande, montantTotal) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, facture.getId());
            statement.setInt(2, facture.getIdCommande());
            statement.setDouble(3, facture.getMontantTotal());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la facture : " + e.getMessage());
        }
    }

    @Override
    public void modifier(Facture facture) {
        String sql = "UPDATE FACTURE SET idCommande = ?, montantTotal = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, facture.getIdCommande());
            statement.setDouble(2, facture.getMontantTotal());
            statement.setInt(3, facture.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de la facture : " + e.getMessage());
        }
    }

    @Override
    public void supprimer(int idFacture) {
        String sql = "DELETE FROM FACTURE WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idFacture);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la facture : " + e.getMessage());
        }
    }

    @Override
    public Facture findById(int idFacture) {
        String sql = "SELECT id, idCommande, montantTotal FROM FACTURE WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idFacture);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Facture(resultSet.getInt("id"), resultSet.getInt("idCommande"), resultSet.getDouble("montantTotal"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la recherche de la facture : " + e.getMessage());
        }
        return null;
    }


    @Override
    public List<Facture> findByIdCommande(int idCommande) {
        List<Facture> factures = new ArrayList<>();
        String sql = "SELECT id, idCommande, montantTotal FROM FACTURE WHERE idCommande = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCommande);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Facture facture = new Facture(resultSet.getInt("id"), resultSet.getInt("idCommande"), resultSet.getDouble("montantTotal"));
                factures.add(facture);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des factures par commande : " + e.getMessage());
        }
        return factures;
    }

    @Override
    public List<Facture> findAll() {
        List<Facture> factures = new ArrayList<>();
        String sql = "SELECT id, idCommande, montantTotal FROM FACTURE";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                factures.add(new Facture(
                    rs.getInt("id"),
                    rs.getInt("idCommande"),
                    rs.getDouble("montantTotal")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des factures : " + e.getMessage());
        }
        return factures;
    }
}
