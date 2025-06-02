package com.monentreprise.gestionstocks.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.monentreprise.gestionstocks.modele.Commande;

public class CommandeImpl implements CommandeDAO {
    private final Connection connection;

    public CommandeImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void ajouter(Commande commande) {
        String sql = "INSERT INTO COMMANDE (idCommande, nomClient, dateCommande, lignes) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, commande.getIdCommande());
            statement.setString(2, commande.getNomClient());
            statement.setDate(3, Date.valueOf(commande.getDateCommande()));
            statement.setObject(4, commande.getLignes()); 
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la commande : " + e.getMessage());
        }
    }

    @Override
    public void modifier(Commande commande) {
        String sql = "UPDATE COMMANDE SET nomClient = ?, dateCommande = ?,  WHERE idCommande = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, commande.getNomClient());
            statement.setDate(2, Date.valueOf(commande.getDateCommande()));
            statement.setInt(3, commande.getIdCommande());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de la commande : " + e.getMessage());
        }
    }

    @Override
    public void supprimer(int idCommande) {
        String sql = "DELETE FROM COMMANDE WHERE idCommande = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCommande);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la commande : " + e.getMessage());
        }
    }

    @Override
    public Commande findById(int idCommande) {
        String sql = "SELECT * FROM COMMANDE WHERE idCommande = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCommande);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Commande(
                    resultSet.getInt("idCommande"),
                    resultSet.getString("nomClient"),
                    resultSet.getDate("dateCommande").toLocalDate(), 
                    new ArrayList<>() // chargement des lignes à faire plus tard
                );
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de la commande : " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Commande> findAll() {
        List<Commande> commandes = new ArrayList<>();
        String sql = "SELECT * FROM COMMANDE";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                commandes.add(new Commande(
                    resultSet.getInt("idCommande"),
                    resultSet.getString("nomClient"),
                    resultSet.getDate("dateCommande").toLocalDate(),
                    new ArrayList<>() // chargement des lignes à faire plus tard
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des commandes : " + e.getMessage());
        }
        return commandes;
    }

    @Override
    public List<Commande> findByNomClient(int idClient) {
        List<Commande> commandes = new ArrayList<>();
        String sql = "SELECT * FROM COMMANDE WHERE idClient = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idClient);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                commandes.add(new Commande(
                    resultSet.getInt("idCommande"),
                    resultSet.getString("nomClient"),
                    resultSet.getDate("dateCommande").toLocalDate(),
                    new ArrayList<>() // chargement des lignes à faire plus tard
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des commandes par client : " + e.getMessage());
        }
        return commandes;
    }
}
