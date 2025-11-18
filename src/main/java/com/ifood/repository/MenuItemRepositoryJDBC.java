package com.ifood.repository;

import com.ifood.model.MenuItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemRepositoryJDBC implements IMenuItemRepository {

    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ifooddb";
        String user = "root";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void add(MenuItem item) {
        String sql = "INSERT INTO menu_items (name, price) VALUES (?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, item.getName());
            stmt.setDouble(2, item.getPrice());
            stmt.executeUpdate();
            System.out.println("✅ Item de menu adicionado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MenuItem item) {
        String sql = "UPDATE menu_items SET name=?, price=? WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, item.getName());
            stmt.setDouble(2, item.getPrice());
            stmt.setInt(3, item.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("🔄 Item de menu atualizado!");
            else
                System.out.println("⚠️ Item de menu não encontrado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM menu_items WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("🗑️ Item de menu removido!");
            else
                System.out.println("⚠️ Item de menu não encontrado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public MenuItem findById(int id) {
        String sql = "SELECT * FROM menu_items WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new MenuItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MenuItem> findAll() {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT * FROM menu_items";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                items.add(new MenuItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
}