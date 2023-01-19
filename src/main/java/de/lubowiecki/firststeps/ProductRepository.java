package de.lubowiecki.firststeps;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private static final String TABLE = "products";

    public List<Product> find() throws SQLException {

        final String sql =  "SELECT * FROM " + TABLE;

        try(Connection connection = DBUtil.getConnection(); Statement stmt = connection.createStatement()) {
            ResultSet results = stmt.executeQuery(sql); // Anfrage an die Datenbank verschicken

            List<Product> products = new ArrayList<>();
            while(results.next()) { // Ergebnisse von der Datenbank durchlaufen
                products.add(create(results)); // Aus jedem Datensatz ein Produkt-Objekt bauen
            }

            return products;
        }
    }

    public Optional<Product> find(int id) throws SQLException {
        throw new UnsupportedOperationException("Noch nicht implementiert");
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
        throw new UnsupportedOperationException("Noch nicht implementiert");
    }

    private boolean update(Product product) throws SQLException {
        throw new UnsupportedOperationException("Noch nicht implementiert");
    }

    public boolean delete(Product product) throws SQLException {
        throw new UnsupportedOperationException("Noch nicht implementiert");
    }

    private Product create(ResultSet result) throws SQLException {
        Product product = new Product();
        product.setId(result.getInt("id"));
        product.setName(result.getString("name"));
        product.setDescription(result.getString("description"));
        product.setPrice(result.getDouble("price"));
        return product;
    }
}
