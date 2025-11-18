package com.ifood.view;

import com.ifood.controller.*;
import com.ifood.model.*;
import java.util.*;

public class MainView {
    private final Scanner scanner = new Scanner(System.in);

    private final CustomerController customerController;
    private final DeliveryPersonController deliveryPersonController;
    private final RestaurantController restaurantController;
    private final MenuItemController menuItemController;
    private final OrderController orderController;

    public MainView(CustomerController customerController,
                    DeliveryPersonController deliveryPersonController,
                    RestaurantController restaurantController,
                    MenuItemController menuItemController,
                    OrderController orderController) {
        
        this.customerController = customerController;
        this.deliveryPersonController = deliveryPersonController;
        this.restaurantController = restaurantController;
        this.menuItemController = menuItemController;
        this.orderController = orderController;
    }
    
    public void start() {
        int option;
        do {
            System.out.println("\n===== MENU IFOOD =====");
            System.out.println("1 - Gerenciar Clientes");
            System.out.println("2 - Gerenciar Entregadores");
            System.out.println("3 - Gerenciar Restaurantes");
            System.out.println("4 - Gerenciar Itens de Menu");
            System.out.println("5 - Gerenciar Pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> manageCustomers();
                case 2 -> manageDeliveryPeople();
                case 3 -> manageRestaurants();
                case 4 -> manageMenuItems();
                case 5 -> manageOrders();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (option != 0);
    }

    // ---------------- CLIENTES ----------------
    private void manageCustomers() {
        System.out.println("\n--- CLIENTES ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Remover");
        System.out.print("Escolha: ");
        int op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Nome: "); String name = scanner.nextLine();
                System.out.print("Telefone: "); String phone = scanner.nextLine();
                System.out.print("Email: "); String email = scanner.nextLine();
                customerController.add(name, phone, email);
            }
            case 2 -> customerController.listAll();
            case 3 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Novo Nome: "); String name = scanner.nextLine();
                System.out.print("Novo Telefone: "); String phone = scanner.nextLine();
                System.out.print("Novo Email: "); String email = scanner.nextLine();
                customerController.update(id, name, phone, email);
            }
            case 4 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                customerController.delete(id);
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    // ---------------- ENTREGADORES ----------------
    private void manageDeliveryPeople() {
        System.out.println("\n--- ENTREGADORES ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Remover");
        System.out.print("Escolha: ");
        int op = scanner.nextInt(); scanner.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Nome: "); String name = scanner.nextLine();
                System.out.print("Veículo: "); String vehicle = scanner.nextLine();
                deliveryPersonController.add(name, vehicle);
            }
            case 2 -> deliveryPersonController.listAll();
            case 3 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Novo Nome: "); String name = scanner.nextLine();
                System.out.print("Novo Veículo: "); String vehicle = scanner.nextLine();
                deliveryPersonController.update(id, name, vehicle);
            }
            case 4 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                deliveryPersonController.delete(id);
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    // ---------------- RESTAURANTES ----------------
    private void manageRestaurants() {
        System.out.println("\n--- RESTAURANTES ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Remover");
        System.out.print("Escolha: ");
        int op = scanner.nextInt(); scanner.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Nome: "); String name = scanner.nextLine();
                restaurantController.add(name);
            }
            case 2 -> restaurantController.listAll();
            case 3 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Novo Nome: "); String name = scanner.nextLine();
                restaurantController.update(id, name);
            }
            case 4 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                restaurantController.delete(id);
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    // ---------------- ITENS DE MENU ----------------
    private void manageMenuItems() {
        System.out.println("\n--- ITENS DE MENU ---");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Remover");
        System.out.print("Escolha: ");
        int op = scanner.nextInt(); scanner.nextLine();

        switch (op) {
            case 1 -> {
                System.out.print("Nome: "); String name = scanner.nextLine();
                System.out.print("Preço: "); double price = scanner.nextDouble();
                menuItemController.add(name, price);
            }
            case 2 -> menuItemController.listAll();
            case 3 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                System.out.print("Novo Nome: "); String name = scanner.nextLine();
                System.out.print("Novo Preço: "); double price = scanner.nextDouble();
                menuItemController.update(id, name, price);
            }
            case 4 -> {
                System.out.print("ID: "); int id = scanner.nextInt(); scanner.nextLine();
                menuItemController.delete(id);
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    // ---------------- PEDIDOS ----------------
    private void manageOrders() {
        System.out.println("\n--- PEDIDOS ---");
        System.out.println("1 - Adicionar Pedido");
        System.out.println("2 - Processar Próximo Pedido");
        System.out.println("3 - Listar Pendentes");
        System.out.println("4 - Listar Concluídos");
        System.out.print("Escolha: ");
        int op = scanner.nextInt(); scanner.nextLine();

        switch (op) {
            case 1 -> {
                // ------ LÓGICA ATUALIZADA ------
                
                // 1. Liste os Restaurantes disponíveis
                System.out.println("--- Restaurantes Disponíveis ---");
                restaurantController.listAll(); // Reutiliza o controller de restaurante
                System.out.print("Digite o ID do Restaurante: ");
                int restId = scanner.nextInt(); scanner.nextLine();

                // 2. Liste os Itens de Menu disponíveis
                System.out.println("\n--- Itens de Menu Disponíveis ---");
                menuItemController.listAll(); // Reutiliza o controller de item
                System.out.print("Digite o ID do Item de Menu: ");
                int itemId = scanner.nextInt(); scanner.nextLine();
                
                // 3. Peça o nome do cliente
                System.out.print("Nome do Cliente (para entrega): ");
                String cliente = scanner.nextLine();

                // 4. Chame o controller atualizado
                orderController.addOrder(cliente, restId, itemId);
            }
            // O resto dos casos continua igual
            case 2 -> orderController.processNextOrder();
            case 3 -> orderController.listPendingOrders();
            case 4 -> orderController.listCompletedOrders();
            default -> System.out.println("Opção inválida!");
        }
    }
}
