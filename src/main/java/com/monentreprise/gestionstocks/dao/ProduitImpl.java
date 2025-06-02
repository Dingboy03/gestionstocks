package com.monentreprise.gestionstocks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.monentreprise.gestionstocks.modele.Produit;

public class ProduitImpl implements ProduitDAO {

    private final Connection connection;

    public ProduitImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Produit findById(int idProduit) {
        String sql = "SELECT * FROM produit WHERE idProduit = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idProduit);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Produit(
                    resultSet.getInt("idProduit"),
                    resultSet.getString("nom"),
                    resultSet.getString("categorie"),
                    resultSet.getDouble("prixUnitaire"),
                    resultSet.getInt("quantiteStock")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT * FROM produit";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                produits.add(new Produit(
                    resultSet.getInt("idProduit"),
                    resultSet.getString("nom"),
                    resultSet.getString("categorie"),
                    resultSet.getDouble("prixUnitaire"),
                    resultSet.getInt("quantiteStock")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public List<Produit> findByCategorie(String categorie) {
        List<Produit> produits = new ArrayList<>();

        if (categorie == null || categorie.isEmpty()) {
            System.err.println("La catégorie ne peut pas être nulle ou vide.");
        }

        String sql = "SELECT * FROM produit WHERE categorie = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, categorie);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                produits.add(new Produit(
                    resultSet.getInt("idProduit"),
                    resultSet.getString("nom"),
                    resultSet.getString("categorie"),
                    resultSet.getDouble("prixUnitaire"),
                    resultSet.getInt("quantiteStock")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produits;
    }

    @Override
    public void ajouter(Produit produit){
        String sql = "ISERT INTO PRODUIT (nom, categorie, prixUnitaire, quantiteStock) VALUES (?,?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, produit.getNom());
            statement.setString(2, produit.getCategorie());
            statement.setDouble(3, produit.getPrixUnitaire());
            statement.setInt(4, produit.getQuantiteStock());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
           
    }

    @Override
    public void modifier(Produit produit){
        String sql = "UPDATE PRODUIT SET nom = ?, categorie = ?, prixUnitaire = ?, quantiteStock = ? WHERE idProduit = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, produit.getNom());
            statement.setString(2, produit.getCategorie());
            statement.setDouble(3, produit.getPrixUnitaire());
            statement.setInt(4, produit.getQuantiteStock());
            statement.setInt(5, produit.getIdProduit());
            statement.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimer(int idProduit) {
        String sql = "DELETE FROM PRODUIT WHERE idProduit=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idProduit);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
