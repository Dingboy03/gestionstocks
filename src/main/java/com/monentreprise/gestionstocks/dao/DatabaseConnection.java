package com.monentreprise.gestionstocks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/projetgestionstock";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Méthode pour obtenir une connexion à la base de données
    public static Connection getConnection() {
        try {
            // Enregistrement explicite du driver JDBC (facultatif à partir de JDBC 4.0)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie à la base de données !");
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("Pilote JDBC introuvable : " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
            return null;
        }
    }

    // Méthode de test (optionnelle)
    public static void main(String[] args) {
        Connection connexion = getConnection();
        if (connexion != null) {
            try {
                connexion.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}
