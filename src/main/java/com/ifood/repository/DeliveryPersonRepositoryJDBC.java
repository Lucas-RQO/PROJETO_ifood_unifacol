package com.ifood.repository;

import com.ifood.model.DeliveryPerson; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryPersonRepositoryJDBC implements IDeliveryPersonRepository {

    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ifooddb";
        String user = "root";
        String password = "123456";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void add(DeliveryPerson deliveryPerson) {
        
        String sql = "INSERT INTO delivery_people (name, phone, vehicle) VALUES (?, ?, ?)";
        
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, deliveryPerson.getName());
            stmt.setString(2, deliveryPerson.getPhone()); // Herdado de Person
            stmt.setString(3, deliveryPerson.getVehicle()); 
            stmt.executeUpdate();
            
            System.out.println("✅ Entregador adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DeliveryPerson deliveryPerson) {
        
        String sql = "UPDATE delivery_people SET name=?, phone=?, vehicle=? WHERE id=?";
        
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, deliveryPerson.getName());
            stmt.setString(2, deliveryPerson.getPhone());
            stmt.setString(3, deliveryPerson.getVehicle());
            stmt.setInt(4, deliveryPerson.getId());
            int rows = stmt.executeUpdate();
            
            if (rows > 0)
                System.out.println("🔄 Entregador atualizado!");
            else
                System.out.println("⚠️ Entregador não encontrado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM delivery_people WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            
            if (rows > 0)
                System.out.println("🗑️ Entregador removido!");
            else
                System.out.println("⚠️ Entregador não encontrado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DeliveryPerson findById(int id) {
        String sql = "SELECT * FROM delivery_people WHERE id=?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                
                return new DeliveryPerson(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("vehicle") 
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DeliveryPerson> findAll() {
        List<DeliveryPerson> deliveryPeople = new ArrayList<>();
        String sql = "SELECT * FROM delivery_people";
        
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                
                deliveryPeople.add(new DeliveryPerson(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("vehicle")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveryPeople;
    }
}