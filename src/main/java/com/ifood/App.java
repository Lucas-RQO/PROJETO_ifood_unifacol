package com.ifood;

import com.ifood.view.MainView;
import com.ifood.controller.*;
import com.ifood.service.*;
import com.ifood.repository.*;

public class App {

    public static void main(String[] args) {
        
        // --- CAMADA DE DADOS (REPOSITORIES) ---
        ICustomerRepository customerRepo = new CustomerRepositoryJDBC();
        IDeliveryPersonRepository dpRepo = new DeliveryPersonRepositoryJDBC();
        IRestaurantRepository restaurantRepo = new RestaurantRepositoryJDBC();
        IMenuItemRepository menuItemRepo = new MenuItemRepositoryJDBC();
        IOrderRepository orderRepo = new OrderInMemoryRepository(); // Em memória

        // --- CAMADA DE NEGÓCIO (SERVICES) ---
        CustomerService customerService = new CustomerService(customerRepo);
        DeliveryPersonService dpService = new DeliveryPersonService(dpRepo);
        RestaurantService restaurantService = new RestaurantService(restaurantRepo);
        MenuItemService menuItemService = new MenuItemService(menuItemRepo);
        OrderService orderService = new OrderService(orderRepo, restaurantRepo, menuItemRepo);
        
        // --- CAMADA DE CONTROLE (CONTROLLERS) ---
        CustomerController customerController = new CustomerController(customerService);
        DeliveryPersonController dpController = new DeliveryPersonController(dpService);
        RestaurantController restaurantController = new RestaurantController(restaurantService);
        MenuItemController menuItemController = new MenuItemController(menuItemService);
        OrderController orderController = new OrderController(orderService);

        // --- CAMADA DE VISUALIZAÇÃO (VIEW) ---
        MainView view = new MainView(
            customerController,
            dpController,
            restaurantController,
            menuItemController,
            orderController
        );

        // --- INICIE A APLICAÇÃO ---
        System.out.println("Bem-vindo ao Sistema de Gerenciamento iFood!");
        view.start();
    }
}