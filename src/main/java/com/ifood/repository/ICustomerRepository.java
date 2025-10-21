package com.ifood.repository;

import com.ifood.model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ICustomerRepository{

    public void add(Customer customer) {
        String sql = "INSERT INTO customers (name, email, phone) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.executeUpdate();

            System.out.println("✅ Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("❌ Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    public void update(Customer customer) {
        String sql = "UPDATE customers SET name=?, email=?, phone=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.setInt(4, customer.getId());
            stmt.executeUpdate();

            System.out.println("✅ Cliente atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("❌ Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM customers WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("✅ Cliente removido com sucesso!");
        } catch (SQLException e) {
            System.err.println("❌ Erro ao remover cliente: " + e.getMessage());
        }
    }

    public Customer findById(int id) {
        String sql = "SELECT * FROM customers WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Customer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao buscar cliente: " + e.getMessage());
        }
        return null;
    }

    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                list.add(new Customer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Erro ao listar clientes: " + e.getMessage());
        }
        return list;
    }
}
