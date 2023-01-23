package de.lubowiecki.firststeps;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private static final String TABLE = "products";

    // Fragt alle Datensätze aus der DB ab
    public List<Product> find() throws SQLException {

        final String sql =  "SELECT * FROM " + TABLE;

        try(Connection connection = DBUtil.getConnection(); Statement stmt = connection.createStatement()) {
            /*
            stmt.execute(sql); // Anfrage an die Datenbank verschicken
            ResultSet results = stmt.getResultSet(); //  Daten abholen
            */

            // ResultSet
            // id(1),   name(2),    description(3),     price(4)  <
            // 1        Mütze       Bla bla bla         19.99
            // 2        Socken      Bla                 7.99

            // ResultSet(Ergebnis)  ist nur verfügbar, solange das zugehörige Statement(Anfrage) da ist
            ResultSet results = stmt.executeQuery(sql); // Anfrage an die Datenbank verschicken und Daten zurückliefern

            List<Product> products = new ArrayList<>();
            while(results.next()) { // Ergebnisse von der Datenbank durchlaufen
                products.add(create(results)); // Aus jedem Datensatz ein Produkt-Objekt bauen
            }

            return products;
        }
    }

    // Fragt einen Datensatz ab
    public Optional<Product> find(int id) throws SQLException {

        final String sql =  "SELECT * FROM " + TABLE + " WHERE id = " + id;

        try(Connection connection = DBUtil.getConnection(); Statement stmt = connection.createStatement()) {
            // executeQuery: Nur SELECT Anweisung d.h. Abfrage von Daten
            ResultSet results = stmt.executeQuery(sql); // Anfrage an die Datenbank verschicken

            if(results.next()) {
                return Optional.of(create(results)); // Datensatz gefunden
            }

            return Optional.empty(); // Kein passender Datensatz in der DB gefunden
        }
    }

    public boolean save(Product product) throws SQLException {

        if(product.getId() > 0) {
            return update(product);
        }
        else {
            return insert(product);
        }
    }

    private boolean insert(Product product) throws SQLException {

        final String sql =  "INSERT INTO " + TABLE + " (id, name, description, price) VALUES(NULL, ?, ?, ?)";

        // PreparedStatement: Schutz gegen SQL-Injection
        // Statement.RETURN_GENERATED_KEYS: Die beim Speichern vergebene ID wir zurückgeliefert
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.execute(); // Schickt die Daten an die DB

            ResultSet rs = stmt.getGeneratedKeys(); // Enthält die IDs, die beim Speichern vergeben wurden
            if(rs.next()) {
                product.setId(rs.getInt(1)); // 1 ist die erste Spalte im ResultSet
                return true;
            }

            return false;
        }
    }

    private boolean update(Product product) throws SQLException {

        final String sql =  "UPDATE " + TABLE + " SET name = ?, description = ?, price = ? WHERE id = ?";

        // PreparedStatement: Schutz gegen SQL-Injection
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setDouble(4, product.getId());

            // executeUpdate: INSERT, UPDATE, DELETE und DDL-Anweisungen. Liefert Anzahl betroffener Datensätze zurück
            // DDL = Data Definition Language: SQL zum Erstellen, Löschen und Verändern von Tabellen
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean delete(Product product) throws SQLException {
        return delete(product.getId());
    }

    public boolean delete(int id) throws SQLException {
        final String sql =  "DELETE FROM " + TABLE + " WHERE id = " + id;

        try(Connection connection = DBUtil.getConnection(); Statement stmt = connection.createStatement()) {
            /*
            stmt.execute(sql); // Anfrage an die Datenbank verschicken
            return stmt.getUpdateCount() > 0; // Liefert die Anzahl betroffener Datensätze
            */
            return stmt.executeUpdate(sql) > 0; // Anfrage an die Datenbank verschicken und Anzahl betroffener Datensätze abholen
        }
    }

    // Mapping: Umwandlung der Datensätze in Java-Objekte
    private Product create(ResultSet result) throws SQLException {
        Product product = new Product();
        product.setId(result.getInt("id"));
        product.setName(result.getString("name"));
        product.setDescription(result.getString("description"));
        product.setPrice(result.getDouble("price"));
        return product;
    }
}
