package com.ifood.service;

import com.ifood.model.*;
import com.ifood.repository.*; 
import java.util.List;
import java.util.ArrayList;

public class OrderService {
    
    
    private final IOrderRepository orderRepository;
    private final IRestaurantRepository restaurantRepository;
    private final IMenuItemRepository menuItemRepository;

    public OrderService(IOrderRepository orderRepository,
                        IRestaurantRepository restaurantRepository,
                        IMenuItemRepository menuItemRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    
    public void addOrder(String customerName, int restaurantId, int menuItemId) {
        
        
        Restaurant restaurant = restaurantRepository.findById(restaurantId);
        MenuItem item = menuItemRepository.findById(menuItemId);

        if (restaurant == null) {
            System.out.println("⚠️ Erro: Restaurante com ID " + restaurantId + " não encontrado.");
            return;
        }
        if (item == null) {
            System.out.println("⚠️ Erro: Item de menu com ID " + menuItemId + " não encontrado.");
            return;
        }

        // 5. Cria a lista de itens e o pedido
        List<MenuItem> items = new ArrayList<>();
        items.add(item);
        
        Order order = new Order(0, customerName, items);
        order.setRestaurant(restaurant); // Define o restaurante no pedido!

        orderRepository.addPending(order);
        System.out.println("✅ Pedido adicionado à fila para o restaurante: " + restaurant.getName());
    }



    public void processNextOrder() {
        Order order = orderRepository.getNextPending();
        if (order != null) {
            order.setStatus(OrderStatus.CONFIRMED); 
            
            orderRepository.addCompleted(order); // Adiciona na pilha de concluídos
            System.out.println("🚚 Processando e concluindo pedido: " + order);
        } else {
            System.out.println("Nenhum pedido pendente.");
        }
    }

    public List<Order> getPendingOrders() {
        return List.copyOf(orderRepository.getPendingOrders());
    }

    public List<Order> getCompletedOrders() {
        return List.copyOf(orderRepository.getCompletedOrders());
    }
}