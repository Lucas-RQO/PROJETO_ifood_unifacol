package com.ifood.repository;

import com.ifood.model.Restaurant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRepositoryJDBC implements IRestaurantRepository {

    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ifooddb";
        String user = "root";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void add(Restaurant restaurant) {
        String sql = "INSERT INTO restaurants (name) VALUES (?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, restaurant.getName());
            stmt.executeUpdate();
            System.out.println("✅ Restaurante adicionado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Restaurant restaurant) {
        String sql = "UPDATE restaurants SET name=? WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, restaurant.getName());
            stmt.setInt(2, restaurant.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("🔄 Restaurante atualizado!");
            else
                System.out.println("⚠️ Restaurante não encontrado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM restaurants WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("🗑️ Restaurante removido!");
            else
                System.out.println("⚠️ Restaurante não encontrado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Restaurant findById(int id) {
        String sql = "SELECT * FROM restaurants WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Usa o construtor COM id
                return new Restaurant(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Restaurant> findAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT * FROM restaurants";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Usa o construtor COM id
                restaurants.add(new Restaurant(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }
}